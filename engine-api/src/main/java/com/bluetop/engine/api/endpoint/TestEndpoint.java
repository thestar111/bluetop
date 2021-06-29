/**
 * 文 件 名:  TestEndpoint
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:39
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engine.api.endpoint;

import com.bluetop.engine.api.bean.Application;
import com.bluetop.engine.api.service.CallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/27 22:39
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@RestController
public class TestEndpoint {

    @Autowired
    private CallerService callerService;

    @PostMapping(path = "/test")
    public Object test(@RequestParam("url") String url, @RequestBody Application json) {
        try {
            return callerService.doPost(url, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(path = "/test1")
    public Object test1(@RequestParam("url") String url, @RequestBody Map data) {
        try {
            return callerService.formData(url, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping(path = "/test2")
    public Object test2(@RequestParam("url") String url, @RequestBody Map data) {
        try {
            return callerService.form(url, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(path = "/test3")
    public Object test3(@RequestParam("url") String url, @RequestParam("path") String path, @RequestBody Application data) {
        try {
            return callerService.doPost(url + path, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
