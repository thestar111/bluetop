/**
 * 文 件 名:  SystemInitializaConfig
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  11:55
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.bluetop.engin.api.bean.Workflow;
import com.bluetop.engin.api.cons.Constans;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <系统初始化>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/4 11:55
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Component
@EnableScheduling
public class CommonCacheBean implements CommandLineRunner {

    /** 流程信息 */
    private final Map<String, Workflow> workflowCache = Maps.newConcurrentMap();

    /** 其他配置缓存 */
    private final Map<String, String> otherCache = Maps.newConcurrentMap();

    /** 流程配置路径 */
    @Value("${workflow.file}")
    private String path;

    /** wsdl配置文件地址 */
    @Value("${wsdl.url:http://180.167.215.157:30182/services/WorkflowService?wsdl}")
    private String url;

    /**
     * 系统启动加载配置
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("【{}】 load workflow file path =========================>>>> {}", getClass().getSimpleName(), path);
        long startTime = System.currentTimeMillis();
        File file = ResourceUtils.getFile(path);
        if (!file.exists()) {
            throw new RuntimeException("流程文件不存在");
        }
        String json = FileUtil.readString(file, "UTF-8");
        JSONArray arrays = JSONUtil.parseArray(json);
        List<Workflow> workflows = JSONUtil.toList(arrays, Workflow.class);
        workflowCache.putAll(workflows.stream().collect(Collectors.toMap(Workflow::getWorkflowId, v -> v, (v1, v2) -> v1)));
        otherCache.put(Constans.ConfigKey.WSDL_URL_KEY, url);
        log.info("【{}】 load workflow config success. cost time ================>>>> {}", getClass().getSimpleName(), System.currentTimeMillis() - startTime);
    }

    /**
     * 获取流程信息
     *
     * @param workflowId
     * @return
     */
    public Workflow getWorkflow(String workflowId) {
        if (StringUtils.isEmpty(workflowId)) {
            return null;
        }
        return workflowCache.get(workflowId);
    }

    /**
     * 获取配置
     *
     * @param key
     * @return
     */
    public String getConfig(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return otherCache.get(key);
    }

    /**
     * 定时刷新配置信息
     */
    @Scheduled(cron = "0 0/2 * * * ?")
    private void refreshCache() throws Exception {
        log.info("【{}】 reload workflow file path =========================>>>> {}", getClass().getSimpleName(), path);
        long startTime = System.currentTimeMillis();
        File file = ResourceUtils.getFile(path);
        String json = FileUtil.readString(file, "UTF-8");
        JSONArray arrays = JSONUtil.parseArray(json);
        List<Workflow> workflows = JSONUtil.toList(arrays, Workflow.class);
        Map<String, Workflow> workflowMap = workflows.stream().collect(Collectors.toMap(Workflow::getWorkflowId, v -> v, (v1, v2) -> v1));
        workflowCache.clear();
        workflowCache.putAll(workflowMap);
        otherCache.clear();
        otherCache.put(Constans.ConfigKey.WSDL_URL_KEY, url);
        log.info("【{}】 reload workflow config success. cost time ================>>>> {}", getClass().getSimpleName(), System.currentTimeMillis() - startTime);
    }
}
