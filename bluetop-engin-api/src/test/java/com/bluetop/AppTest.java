package com.bluetop;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.bluetop.engin.api.model.NameAndValue;
import com.bluetop.engin.api.model.TableDetailInfo;
import com.bluetop.engin.api.param.CreateWorkflowRequest;
import com.bluetop.engin.api.webservice.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setUserId("162");
        createWorkflowRequest.setWorkflowId("84");
        ObjectFactory objFac = new ObjectFactory();

        WorkflowRequestInfo wri = objFac.createWorkflowRequestInfo();
        wri.setCreatorId(createWorkflowRequest.getUserId());
        wri.setRequestName("周平测试-合同审批");
        wri.setRequestLevel("0");

        // 流程主表信息
        WorkflowMainTableInfo workflowMainTableInfo = objFac.createWorkflowMainTableInfo();
        ArrayOfWorkflowRequestTableRecord arrayOfWorkflowRequestTableRecord = objFac.createArrayOfWorkflowRequestTableRecord();
        List<WorkflowRequestTableRecord> workflowRequestTableRecords = arrayOfWorkflowRequestTableRecord.getWorkflowRequestTableRecord();
        WorkflowRequestTableRecord workflowRequestTableRecord = objFac.createWorkflowRequestTableRecord();
        workflowRequestTableRecords.add(workflowRequestTableRecord);
        ArrayOfWorkflowRequestTableField arrayOfWorkflowRequestTableField = objFac.createArrayOfWorkflowRequestTableField();
        workflowRequestTableRecord.setWorkflowRequestTableFields(arrayOfWorkflowRequestTableField);
        List<WorkflowRequestTableField> workflowRequestTableFields = arrayOfWorkflowRequestTableField.getWorkflowRequestTableField();
        WorkflowRequestTableField workflowRequestTableField = createWorkflowRequestTableField("htmc", "合同名称");
        workflowRequestTableFields.add(workflowRequestTableField);
        WorkflowRequestTableField workflowRequestTableField1 = createWorkflowRequestTableField("htbh", "202104030000000");
        workflowRequestTableFields.add(workflowRequestTableField1);
        WorkflowRequestTableField workflowRequestTableField2 = createWorkflowRequestTableField("yjje", "100");
        workflowRequestTableFields.add(workflowRequestTableField2);
        WorkflowRequestTableField workflowRequestTableField3 = createWorkflowRequestTableField("htqx", "2021-04-03");
        workflowRequestTableFields.add(workflowRequestTableField3);
        WorkflowRequestTableField workflowRequestTableField4 = createWorkflowRequestTableField("ddqx", "2021-04-03");
        workflowRequestTableFields.add(workflowRequestTableField4);
        WorkflowRequestTableField workflowRequestTableField5 = createWorkflowRequestTableField("khmc", "周平");
        workflowRequestTableFields.add(workflowRequestTableField5);
        WorkflowRequestTableField workflowRequestTableField6 = createWorkflowRequestTableField("yf", "周平");
        workflowRequestTableFields.add(workflowRequestTableField6);
        WorkflowRequestTableField workflowRequestTableField7 = createWorkflowRequestTableField("htjf", "湖南蓝佑科技有限公司");
        workflowRequestTableFields.add(workflowRequestTableField7);
        WorkflowRequestTableField workflowRequestTableField8 = createWorkflowRequestTableField("ppmc", "湖南蓝佑科技有限公司");
        workflowRequestTableFields.add(workflowRequestTableField8);
        WorkflowRequestTableField workflowRequestTableField9 = createWorkflowRequestTableField("khmc", "周平");
        workflowRequestTableFields.add(workflowRequestTableField9);
        WorkflowRequestTableField workflowRequestTableField11 = createWorkflowRequestTableField("bzfj", "www.baidu.com/1.pdf");
        workflowRequestTableFields.add(workflowRequestTableField11);
        WorkflowRequestTableField workflowRequestTableField12 = createWorkflowRequestTableField("fbzfj", "www.baidu.com/1.pdf");
        workflowRequestTableFields.add(workflowRequestTableField12);
        WorkflowRequestTableField workflowRequestTableField13 = createWorkflowRequestTableField("htlx", "包房合同");
        workflowRequestTableFields.add(workflowRequestTableField13);
        WorkflowRequestTableField workflowRequestTableField14 = createWorkflowRequestTableField("bgsxrq", "变更生效日期");
        workflowRequestTableFields.add(workflowRequestTableField14);
        WorkflowRequestTableField workflowRequestTableField15 = createWorkflowRequestTableField("tsrq", "100000000");
        workflowRequestTableFields.add(workflowRequestTableField15);
        WorkflowRequestTableField workflowRequestTableField16 = createWorkflowRequestTableField("ddbh", "D00000999999");
        workflowRequestTableFields.add(workflowRequestTableField16);
        WorkflowRequestTableField workflowRequestTableField17 = createWorkflowRequestTableField("xsry", "周平");
        workflowRequestTableFields.add(workflowRequestTableField17);
        WorkflowRequestTableField workflowRequestTableField18 = createWorkflowRequestTableField("jffs", "按天计费");
        workflowRequestTableFields.add(workflowRequestTableField18);

        workflowRequestTableFields.add(createWorkflowRequestTableField("jszq", "结算周期"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("skrq", "每周"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("yjzflx", "支付宝"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("kplx", "普票"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("kptt", "湖南蓝佑科技有限公司"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("kpfs", "电子发票"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("kpnr", "办公用品"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("bzhtfbht", "标准合同"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("ydsj", "赢单商机"));
        workflowRequestTableFields.add(createWorkflowRequestTableField("bz", "备注"));

        workflowMainTableInfo.setRequestRecords(arrayOfWorkflowRequestTableRecord);
        wri.setWorkflowMainTableInfo(workflowMainTableInfo);

        // 流程详细信息
        ArrayOfWorkflowDetailTableInfo arrayOfWorkflowDetailTableInfo = objFac.createArrayOfWorkflowDetailTableInfo();
        List<WorkflowDetailTableInfo> workflowDetailTableInfos = arrayOfWorkflowDetailTableInfo.getWorkflowDetailTableInfo();

        // 明细表1
        Map<String, String> fields1 = Maps.newHashMap();
        fields1.put("md", "喜盈门");
        fields1.put("bfbc", "包房");
        fields1.put("fx", "三室一厅");
        fields1.put("sl", "5");
        fields1.put("xsdj", "100");
        fields1.put("dj", "100");
        fields1.put("yze", "10000");
        fields1.put("sftpdj", "否");
        fields1.put("cwdj", "50");
        workflowDetailTableInfos.add(createDetailTableInfo(objFac, Lists.newArrayList(fields1)));

        // 明细表2
        Map<String, String> fields2 = Maps.newHashMap();
        fields2.put("md", "德思勤");
        fields2.put("yfryyj", "500");
        fields2.put("df", "500");
        fields2.put("lsf", "700");
        fields2.put("rsf", "500");
        fields2.put("wf", "200");
        fields2.put("wyf", "100");
        fields2.put("df1", "100");
        fields2.put("df2", "100");
        fields2.put("lsf1", "100");
        fields2.put("lsf2", "100");
        fields2.put("rsf1", "100");
        fields2.put("rsf2", "100");
        fields2.put("wf1", "100");
        fields2.put("wf2", "100");
        fields2.put("wyf1", "100");
        fields2.put("wyf2", "100");
        workflowDetailTableInfos.add(createDetailTableInfo(objFac, Lists.newArrayList(fields2)));

        // 明细表6
        Map<String, String> fields3 = Maps.newHashMap();
        fields3.put("md", "五一广场");
        fields3.put("km", "1");
        fields3.put("je", "3000");
        fields3.put("zq", "202104");
        fields3.put("zwzfr", "2021-05-01");
        workflowDetailTableInfos.add(createDetailTableInfo(objFac, Lists.newArrayList(fields3)));

        wri.setWorkflowDetailTableInfos(arrayOfWorkflowDetailTableInfo);

        // 流程基础信息
        WorkflowBaseInfo wbi = objFac.createWorkflowBaseInfo();
        wbi.setWorkflowId(createWorkflowRequest.getWorkflowId());
        wri.setWorkflowBaseInfo(wbi);
        System.out.println(JSONUtil.toJsonStr(wri));
    }

    @Test
    public void requestParam() {
        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setWorkflowId("84");
        createWorkflowRequest.setUserId("162");
        List<NameAndValue> main = Lists.newArrayList();
        main.add(new NameAndValue("htmc", "合同名称"));
        main.add(new NameAndValue("htbh", "202104030000000"));
        main.add(new NameAndValue("yjje", "100"));
        main.add(new NameAndValue("htqx", "2021-04-03"));
        main.add(new NameAndValue("ddqx", "2021-04-03"));
        main.add(new NameAndValue("khmc", "周平"));
        main.add(new NameAndValue("yf", "周平"));
        main.add(new NameAndValue("htjf", "湖南蓝佑科技有限公司"));
        main.add(new NameAndValue("ppmc", "湖南蓝佑科技有限公司"));
        main.add(new NameAndValue("khmc", "周平"));
        main.add(new NameAndValue("bzfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        main.add(new NameAndValue("fbzfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        main.add(new NameAndValue("htlx", "包房合同"));
        main.add(new NameAndValue("bgsxrq", "变更生效日期"));
        main.add(new NameAndValue("tsrq", "100000000"));
        main.add(new NameAndValue("ddbh", "D00000999999"));
        main.add(new NameAndValue("xsry", "周平"));
        main.add(new NameAndValue("jffs", "按天计费"));
        main.add(new NameAndValue("jszq", "结算周期"));
        main.add(new NameAndValue("skrq", "每周"));
        main.add(new NameAndValue("yjzflx", "支付宝"));
        main.add(new NameAndValue("kplx", "普票"));
        main.add(new NameAndValue("kptt", "湖南蓝佑科技有限公司"));
        main.add(new NameAndValue("kpfs", "电子发票"));
        main.add(new NameAndValue("kpnr", "办公用品"));
        main.add(new NameAndValue("bzhtfbht", "标准合同"));
        main.add(new NameAndValue("ydsj", "赢单商机"));
        main.add(new NameAndValue("bz", "备注"));
        createWorkflowRequest.setWorkflowMainTables(main);

        List<TableDetailInfo> tableDetailInfos = Lists.newArrayList();
        TableDetailInfo t3 = new TableDetailInfo();
        t3.setOrder(3);
        List<List<NameAndValue>> d3 = Lists.newArrayList();
        List<NameAndValue> dt1 = Lists.newArrayList();
        dt1.add(new NameAndValue("md", "五一广场"));
        dt1.add(new NameAndValue("km", "1"));
        dt1.add(new NameAndValue("je", "3000"));
        dt1.add(new NameAndValue("zq", "202104"));
        dt1.add(new NameAndValue("zwzfr", "2021-05-01"));
        List<NameAndValue> dt2 = Lists.newArrayList();
        dt2.add(new NameAndValue("md", "五一广场"));
        dt2.add(new NameAndValue("km", "1"));
        dt2.add(new NameAndValue("je", "3000"));
        dt2.add(new NameAndValue("zq", "202104"));
        dt2.add(new NameAndValue("zwzfr", "2021-05-01"));
        d3.add(dt1);
        d3.add(dt2);
        t3.setTableInfos(d3);
        tableDetailInfos.add(t3);

        TableDetailInfo t2 = new TableDetailInfo();
        t2.setOrder(2);
        List<List<NameAndValue>> d2 = Lists.newArrayList();
        List<NameAndValue> r1 = Lists.newArrayList();
        r1.add(new NameAndValue("md", "德思勤"));
        r1.add(new NameAndValue("yfryyj", "500"));
        r1.add(new NameAndValue("df", "500"));
        r1.add(new NameAndValue("lsf", "700"));
        r1.add(new NameAndValue("rsf", "500"));
        r1.add(new NameAndValue("wf", "200"));
        r1.add(new NameAndValue("wyf", "100"));
        r1.add(new NameAndValue("df1", "100"));
        r1.add(new NameAndValue("df2", "100"));
        r1.add(new NameAndValue("lsf1", "100"));
        r1.add(new NameAndValue("lsf2", "100"));
        r1.add(new NameAndValue("rsf1", "100"));
        r1.add(new NameAndValue("rsf2", "100"));
        r1.add(new NameAndValue("wf1", "100"));
        r1.add(new NameAndValue("wf2", "100"));
        r1.add(new NameAndValue("wyf1", "100"));
        r1.add(new NameAndValue("wyf2", "100"));
        List<NameAndValue> r2 = Lists.newArrayList();
        r2.add(new NameAndValue("md", "德思勤"));
        r2.add(new NameAndValue("yfryyj", "500"));
        r2.add(new NameAndValue("df", "500"));
        r2.add(new NameAndValue("lsf", "700"));
        r2.add(new NameAndValue("rsf", "500"));
        r2.add(new NameAndValue("wf", "200"));
        r2.add(new NameAndValue("wyf", "100"));
        r2.add(new NameAndValue("df1", "100"));
        r2.add(new NameAndValue("df2", "100"));
        r2.add(new NameAndValue("lsf1", "100"));
        r2.add(new NameAndValue("lsf2", "100"));
        r2.add(new NameAndValue("rsf1", "100"));
        r2.add(new NameAndValue("rsf2", "100"));
        r2.add(new NameAndValue("wf1", "100"));
        r2.add(new NameAndValue("wf2", "100"));
        r2.add(new NameAndValue("wyf1", "100"));
        r2.add(new NameAndValue("wyf2", "100"));
        d2.add(r1);
        d2.add(r2);
        t2.setTableInfos(d2);
        tableDetailInfos.add(t2);

        TableDetailInfo t1 = new TableDetailInfo();
        t1.setOrder(1);
        List<List<NameAndValue>> d1 = Lists.newArrayList();
        List<NameAndValue> r01 = Lists.newArrayList();
        r01.add(new NameAndValue("md", "喜盈门"));
        r01.add(new NameAndValue("bfbc", "包房"));
        r01.add(new NameAndValue("fx", "三室一厅"));
        r01.add(new NameAndValue("sl", "5"));
        r01.add(new NameAndValue("xsdj", "100"));
        r01.add(new NameAndValue("dj", "100"));
        r01.add(new NameAndValue("yze", "10000"));
        r01.add(new NameAndValue("sftpdj", "否"));
        r01.add(new NameAndValue("cwdj", "50"));
        List<NameAndValue> r02 = Lists.newArrayList();
        r02.add(new NameAndValue("md", "喜盈门"));
        r02.add(new NameAndValue("bfbc", "包房"));
        r02.add(new NameAndValue("fx", "三室一厅"));
        r02.add(new NameAndValue("sl", "5"));
        r02.add(new NameAndValue("xsdj", "100"));
        r02.add(new NameAndValue("dj", "100"));
        r02.add(new NameAndValue("yze", "10000"));
        r02.add(new NameAndValue("sftpdj", "否"));
        r02.add(new NameAndValue("cwdj", "50"));
        d1.add(r01);
        d1.add(r02);
        t1.setTableInfos(d1);
        tableDetailInfos.add(t1);

        createWorkflowRequest.setWorkflowDetailTables(tableDetailInfos);

        System.out.println(JSONUtil.toJsonStr(createWorkflowRequest));
    }

    /**
     * 框架协议-合同及订单审批
     */
    @Test
    public void requestOrderReview() {
        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setWorkflowId("85");
        createWorkflowRequest.setUserId("162");
        List<NameAndValue> main = Lists.newArrayList();
        main.add(new NameAndValue("htbh", "HT10000009"));
        main.add(new NameAndValue("htmc", "MC测试合同"));
        main.add(new NameAndValue("yjje", "300"));
        main.add(new NameAndValue("htqx", "30天"));
        main.add(new NameAndValue("ddqx", "2021-04-07"));
        main.add(new NameAndValue("htjf", "北京蓝拓有限公司"));
        main.add(new NameAndValue("yf", "乙方"));
        main.add(new NameAndValue("khmc", "湖南蓝佑"));
        main.add(new NameAndValue("ppmc", "安歆公寓"));
        main.add(new NameAndValue("htlx", "普通合同"));
        main.add(new NameAndValue("bgsxrq", "2021-04-03"));
        main.add(new NameAndValue("tsrq", "Y202104030000000"));
        main.add(new NameAndValue("ddbh", "D202104030000000"));
        main.add(new NameAndValue("xsry", "周平"));
        main.add(new NameAndValue("jffs", "按天"));
        main.add(new NameAndValue("jszq", "30天"));
        main.add(new NameAndValue("skrq", "2021-04-09"));
        main.add(new NameAndValue("yjzflx", "支付宝"));
        main.add(new NameAndValue("kplx", "普票"));
        main.add(new NameAndValue("kptt", "北京蓝拓股份有限公司"));
        main.add(new NameAndValue("kpfs", "电子"));
        main.add(new NameAndValue("kpnr", "办公用品"));
        main.add(new NameAndValue("bzhtfbht", "标准"));
        main.add(new NameAndValue("ydsj", "赢单商机"));
        main.add(new NameAndValue("bz", "备注"));
        main.add(new NameAndValue("bzfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        main.add(new NameAndValue("fbzfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        createWorkflowRequest.setWorkflowMainTables(main);

        List<TableDetailInfo> tableDetailInfos = Lists.newArrayList();
        TableDetailInfo t3 = new TableDetailInfo();
        t3.setOrder(3);
        List<List<NameAndValue>> d3 = Lists.newArrayList();
        List<NameAndValue> dt1 = Lists.newArrayList();
        dt1.add(new NameAndValue("md", "五一广场"));
        dt1.add(new NameAndValue("km", "1"));
        dt1.add(new NameAndValue("je", "3000"));
        dt1.add(new NameAndValue("zq", "202104"));
        dt1.add(new NameAndValue("zwzfr", "2021-05-01"));
        d3.add(dt1);
        t3.setTableInfos(d3);
        tableDetailInfos.add(t3);

        TableDetailInfo t2 = new TableDetailInfo();
        t2.setOrder(2);
        List<List<NameAndValue>> d2 = Lists.newArrayList();
        List<NameAndValue> r1 = Lists.newArrayList();
        r1.add(new NameAndValue("md", "德思勤"));
        r1.add(new NameAndValue("yfryyj", "500"));
        r1.add(new NameAndValue("df", "500"));
        r1.add(new NameAndValue("lsf", "700"));
        r1.add(new NameAndValue("rsf", "500"));
        r1.add(new NameAndValue("wf", "200"));
        r1.add(new NameAndValue("wyf", "100"));
        r1.add(new NameAndValue("df1", "100"));
        r1.add(new NameAndValue("df2", "100"));
        r1.add(new NameAndValue("lsf1", "100"));
        r1.add(new NameAndValue("lsf2", "100"));
        r1.add(new NameAndValue("rsf1", "100"));
        r1.add(new NameAndValue("rsf2", "100"));
        r1.add(new NameAndValue("wf1", "100"));
        r1.add(new NameAndValue("wf2", "100"));
        r1.add(new NameAndValue("wyf1", "100"));
        r1.add(new NameAndValue("wyf2", "100"));
        d2.add(r1);
        t2.setTableInfos(d2);
        tableDetailInfos.add(t2);

        TableDetailInfo t1 = new TableDetailInfo();
        t1.setOrder(1);
        List<List<NameAndValue>> d1 = Lists.newArrayList();
        List<NameAndValue> r01 = Lists.newArrayList();
        r01.add(new NameAndValue("md", "喜盈门"));
        r01.add(new NameAndValue("bfbc", "包房"));
        r01.add(new NameAndValue("fx", "三室一厅"));
        r01.add(new NameAndValue("sl", "5"));
        r01.add(new NameAndValue("xsdj", "100"));
        r01.add(new NameAndValue("dj", "100"));
        r01.add(new NameAndValue("yze", "10000"));
        r01.add(new NameAndValue("sftpdj", "否"));
        r01.add(new NameAndValue("cwdj", "50"));
        d1.add(r01);
        t1.setTableInfos(d1);
        tableDetailInfos.add(t1);

        createWorkflowRequest.setWorkflowDetailTables(tableDetailInfos);

        System.out.println(JSONUtil.toJsonStr(createWorkflowRequest));
    }

    /**
     * 战略合作-合同审批
     */
    @Test
    public void requestContractReview() {
        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setWorkflowId("83");
        createWorkflowRequest.setUserId("162");
        List<NameAndValue> main = Lists.newArrayList();
        main.add(new NameAndValue("htbh", "HT10000009"));
        main.add(new NameAndValue("htmc", "MC测试合同"));
        main.add(new NameAndValue("yjje", "300"));
        main.add(new NameAndValue("htqx", "30天"));
        main.add(new NameAndValue("ddqx", "2021-04-07"));
        main.add(new NameAndValue("htjf", "北京蓝拓有限公司"));
        main.add(new NameAndValue("yf", "乙方"));
        main.add(new NameAndValue("khmc", "湖南蓝佑"));
        main.add(new NameAndValue("ppmc", "安歆公寓"));
        main.add(new NameAndValue("htlx", "普通合同"));
        main.add(new NameAndValue("bgsxrq", "2021-04-03"));
        main.add(new NameAndValue("tsrq", "Y202104030000000"));
        main.add(new NameAndValue("ddbh", "D202104030000000"));
        main.add(new NameAndValue("xsry", "周平"));
        main.add(new NameAndValue("jffs", "按天"));
        main.add(new NameAndValue("jszq", "30天"));
        main.add(new NameAndValue("skrq", "2021-04-09"));
        main.add(new NameAndValue("yjzflx", "支付宝"));
        main.add(new NameAndValue("kplx", "普票"));
        main.add(new NameAndValue("kptt", "北京蓝拓股份有限公司"));
        main.add(new NameAndValue("kpfs", "电子"));
        main.add(new NameAndValue("kpnr", "办公用品"));
        main.add(new NameAndValue("bzhtfbht", "标准"));
        main.add(new NameAndValue("ydsj", "赢单商机"));
        main.add(new NameAndValue("bz", "备注"));
        main.add(new NameAndValue("bzfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        main.add(new NameAndValue("fbzfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        createWorkflowRequest.setWorkflowMainTables(main);

        List<TableDetailInfo> tableDetailInfos = Lists.newArrayList();
        TableDetailInfo t3 = new TableDetailInfo();
        t3.setOrder(2);
        List<List<NameAndValue>> d3 = Lists.newArrayList();
        List<NameAndValue> dt1 = Lists.newArrayList();
        dt1.add(new NameAndValue("md", "五一广场"));
        dt1.add(new NameAndValue("km", "1"));
        dt1.add(new NameAndValue("je", "3000"));
        dt1.add(new NameAndValue("zq", "202104"));
        dt1.add(new NameAndValue("zwzfr", "2021-05-01"));
        d3.add(dt1);
        t3.setTableInfos(d3);
        tableDetailInfos.add(t3);

        TableDetailInfo t1 = new TableDetailInfo();
        t1.setOrder(1);
        List<List<NameAndValue>> d1 = Lists.newArrayList();
        List<NameAndValue> r01 = Lists.newArrayList();
        r01.add(new NameAndValue("md", "喜盈门"));
        r01.add(new NameAndValue("bfbc", "包房"));
        r01.add(new NameAndValue("fx", "三室一厅"));
        r01.add(new NameAndValue("sl", "5"));
        r01.add(new NameAndValue("xsdj", "100"));
        r01.add(new NameAndValue("dj", "100"));
        r01.add(new NameAndValue("yze", "10000"));
        r01.add(new NameAndValue("sftpdj", "否"));
        r01.add(new NameAndValue("cwdj", "50"));
        d1.add(r01);
        t1.setTableInfos(d1);
        tableDetailInfos.add(t1);

        createWorkflowRequest.setWorkflowDetailTables(tableDetailInfos);

        System.out.println(JSONUtil.toJsonStr(createWorkflowRequest));
    }

    /**
     * 合同模板审批(有问题)
     */
    @Test
    public void requestParam1() {
        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setWorkflowId("76");
        createWorkflowRequest.setUserId("162");
        List<NameAndValue> main = Lists.newArrayList();
        main.add(new NameAndValue("xkhmc", "周平"));
        main.add(new NameAndValue("ddbh", "产品线"));
        main.add(new NameAndValue("mblx", "模板类型"));
        main.add(new NameAndValue("yjje", "0")); // 0 ：是  1：否
        main.add(new NameAndValue("htqx", "www.baidu.com"));
        main.add(new NameAndValue("xsry", "周平"));
        createWorkflowRequest.setWorkflowMainTables(main);

        List<TableDetailInfo> tableDetailInfos = Lists.newArrayList();

        TableDetailInfo t1 = new TableDetailInfo();
        t1.setOrder(1);
        List<List<NameAndValue>> d1 = Lists.newArrayList();
        List<NameAndValue> r01 = Lists.newArrayList();
        r01.add(new NameAndValue("md", "喜盈门"));
        r01.add(new NameAndValue("bfbc", "包房"));
        r01.add(new NameAndValue("fx", "三室一厅"));
        r01.add(new NameAndValue("sl", "5"));
        r01.add(new NameAndValue("xsdj", "100"));
        r01.add(new NameAndValue("dj", "100"));
        r01.add(new NameAndValue("yze", "10000"));
        r01.add(new NameAndValue("sftpdj", "否"));
        r01.add(new NameAndValue("cwdj", "50"));
        d1.add(r01);
        t1.setTableInfos(d1);
        tableDetailInfos.add(t1);

        createWorkflowRequest.setWorkflowDetailTables(tableDetailInfos);

        System.out.println(JSONUtil.toJsonStr(createWorkflowRequest));
    }


    /**
     * 归档审批（有问题）
     */
    @Test
    public void requestParam2() {
        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setWorkflowId("77");
        createWorkflowRequest.setUserId("162");
        List<NameAndValue> main = Lists.newArrayList();
        main.add(new NameAndValue("htbh", "HT10000009"));
        main.add(new NameAndValue("htmc", "MC测试合同"));
        main.add(new NameAndValue("jffs", "按天"));
        main.add(new NameAndValue("jszq", "按天"));
        main.add(new NameAndValue("htqx", "30天"));
        main.add(new NameAndValue("skrq", "2021-04-03"));
        main.add(new NameAndValue("yjzflx", "支付宝"));
        main.add(new NameAndValue("yjje", "300"));
        main.add(new NameAndValue("kplx", "普票"));
        main.add(new NameAndValue("kptt", "湖南蓝佑"));
        main.add(new NameAndValue("kpfs", "电子"));
        main.add(new NameAndValue("kpnr", "办公用品"));
        main.add(new NameAndValue("bzhtfbht", "标砖"));
        main.add(new NameAndValue("xsry", "周平"));
        main.add(new NameAndValue("ydsj", "赢单商机"));
        main.add(new NameAndValue("bz", "备注"));
        main.add(new NameAndValue("jf", "甲方"));
        main.add(new NameAndValue("yf", "乙方"));
        main.add(new NameAndValue("khmc", "周平"));
        main.add(new NameAndValue("ppmc", "新冠"));
        main.add(new NameAndValue("bzfj1", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        main.add(new NameAndValue("fbzfj1", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        createWorkflowRequest.setWorkflowMainTables(main);

        List<TableDetailInfo> tableDetailInfos = Lists.newArrayList();

        TableDetailInfo t1 = new TableDetailInfo();
        t1.setOrder(1);
        List<List<NameAndValue>> d1 = Lists.newArrayList();
        List<NameAndValue> r01 = Lists.newArrayList();
        r01.add(new NameAndValue("gzwj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        r01.add(new NameAndValue("gdwj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg", "0.jpg"));
        d1.add(r01);
        t1.setTableInfos(d1);
        tableDetailInfos.add(t1);

        createWorkflowRequest.setWorkflowDetailTables(tableDetailInfos);

        System.out.println(JSONUtil.toJsonStr(createWorkflowRequest));
    }

    /**
     * 客户信息新增/修改
     */
    @Test
    public void requestParam3() {
        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setWorkflowId("75");
        createWorkflowRequest.setUserId("162");
        List<NameAndValue> main = Lists.newArrayList();
        main.add(new NameAndValue("tsrq", "KH00000000001"));
        main.add(new NameAndValue("tslx", "VIP客户"));
        main.add(new NameAndValue("tsyy", "正常"));
        main.add(new NameAndValue("tscws", "周平"));
        main.add(new NameAndValue("htbh", "原客户：周平"));
        main.add(new NameAndValue("xkhmc", "新客户：周平"));
        main.add(new NameAndValue("htmc", "集团名称：太阳集团"));
        main.add(new NameAndValue("ddbh", "新集团名称：月亮集团"));
        main.add(new NameAndValue("yjje", "原客户行业：印钞票"));
        main.add(new NameAndValue("htqx", "新客户行业：印钞票"));
        main.add(new NameAndValue("ddqx", "原品牌名称：李宁"));
        main.add(new NameAndValue("xsry", "新品牌名称：李宁"));
        main.add(new NameAndValue("bz", "原客户来源"));
        main.add(new NameAndValue("htjf", "新客户来源"));
        main.add(new NameAndValue("yf", "原身份证号：000000000000000000"));
        main.add(new NameAndValue("khmc", "新身份证号：000000000000009"));
        createWorkflowRequest.setWorkflowMainTables(main);

        System.out.println(JSONUtil.toJsonStr(createWorkflowRequest));
    }

    /**
     * 退宿单审批
     */
    @Test
    public void requestParam4() {
        CreateWorkflowRequest createWorkflowRequest = new CreateWorkflowRequest();
        createWorkflowRequest.setWorkflowId("74");
        createWorkflowRequest.setUserId("162");
        List<NameAndValue> main = Lists.newArrayList();
        main.add(new NameAndValue("tsrq", "2021-04-02"));
        main.add(new NameAndValue("tslx", "直接退宿"));
        main.add(new NameAndValue("tsyy", "合同到期"));
        main.add(new NameAndValue("tscws", "1"));
        main.add(new NameAndValue("htbh", "20000000001111"));
        main.add(new NameAndValue("htmc", "退宿单名称"));
        main.add(new NameAndValue("ddbh", "DD000000000000000001"));
        main.add(new NameAndValue("yjje", "300"));
        main.add(new NameAndValue("htqx", "2021-04-02"));
        main.add(new NameAndValue("ddqx", "2021-04-01"));
        main.add(new NameAndValue("xsry", "周平"));
        main.add(new NameAndValue("bz", "备注"));
        main.add(new NameAndValue("htjf", "甲方:周平"));
        main.add(new NameAndValue("yf", "乙方：蓝佑"));
        main.add(new NameAndValue("khmc", "周平"));
        main.add(new NameAndValue("ppmc", "新冠"));
        main.add(new NameAndValue("bzfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg"));
        main.add(new NameAndValue("fbfj", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2069542074,3354686813&fm=26&gp=0.jpg"));
        createWorkflowRequest.setWorkflowMainTables(main);

        List<TableDetailInfo> tableDetailInfos = Lists.newArrayList();

        TableDetailInfo t1 = new TableDetailInfo();
        t1.setOrder(1);
        List<List<NameAndValue>> d1 = Lists.newArrayList();
        List<NameAndValue> r01 = Lists.newArrayList();
        r01.add(new NameAndValue("md", "喜盈门"));
        r01.add(new NameAndValue("bfbc", "包房"));
        r01.add(new NameAndValue("fx", "三室一厅"));
        r01.add(new NameAndValue("sl", "5"));
        r01.add(new NameAndValue("xsdj", "100"));
        r01.add(new NameAndValue("dj", "100"));
        r01.add(new NameAndValue("yze", "10000"));
        r01.add(new NameAndValue("sftpdj", "否"));
        r01.add(new NameAndValue("cwdj", "50"));

        d1.add(r01);
        t1.setTableInfos(d1);
        tableDetailInfos.add(t1);

        createWorkflowRequest.setWorkflowDetailTables(tableDetailInfos);

        System.out.println(JSONUtil.toJsonStr(createWorkflowRequest));
    }

    /**
     * 创建明细表
     *
     * @param objFac
     */
    private WorkflowDetailTableInfo createDetailTableInfo(ObjectFactory objFac, List<Map<String, String>> fields) {
        WorkflowDetailTableInfo workflowDetailTableInfo = new WorkflowDetailTableInfo();
        if (CollectionUtil.isEmpty(fields)) {
            return workflowDetailTableInfo;
        }
        ArrayOfWorkflowRequestTableRecord arrayOfWorkflowRequestTableRecord = objFac.createArrayOfWorkflowRequestTableRecord();
        List<WorkflowRequestTableRecord> workflowRequestDetailTableRecords = arrayOfWorkflowRequestTableRecord.getWorkflowRequestTableRecord();
        WorkflowRequestTableRecord workflowRequestTableRecord = objFac.createWorkflowRequestTableRecord();
        ArrayOfWorkflowRequestTableField arrayOfWorkflowRequestTableField = objFac.createArrayOfWorkflowRequestTableField();
        List<WorkflowRequestTableField> workflowRequestTableFields = arrayOfWorkflowRequestTableField.getWorkflowRequestTableField();
        for (Map<String, String> field : fields) {
            workflowRequestTableFields.addAll(createWorkflowRequestTableField(field));
        }
        workflowRequestTableRecord.setWorkflowRequestTableFields(arrayOfWorkflowRequestTableField);
        workflowRequestDetailTableRecords.add(workflowRequestTableRecord);
        workflowDetailTableInfo.setWorkflowRequestTableRecords(arrayOfWorkflowRequestTableRecord);
        return workflowDetailTableInfo;
    }

    /**
     * 创建明细单
     *
     * @param filedNameAndValue
     * @return
     */
    public List<WorkflowRequestTableField> createWorkflowRequestTableField(Map<String, String> filedNameAndValue) {
        if (Objects.isNull(filedNameAndValue)) {
            Lists.newArrayList();
        }
        List<WorkflowRequestTableField> workflowRequestTableFields = Lists.newArrayList();
        for (String key : filedNameAndValue.keySet()) {
            WorkflowRequestTableField workflowRequestTableField = new WorkflowRequestTableField();
            workflowRequestTableField.setFieldName(key);
            workflowRequestTableField.setFieldValue(filedNameAndValue.get(key));
            workflowRequestTableField.setEdit(true);
            workflowRequestTableField.setView(true);
            workflowRequestTableFields.add(workflowRequestTableField);
        }
        return workflowRequestTableFields;
    }

    /**
     * 创建工作流表单属性
     *
     * @param name  字段名称
     * @param value 字段值
     * @return
     */
    private WorkflowRequestTableField createWorkflowRequestTableField(String name, String value) {
        WorkflowRequestTableField workflowRequestTableField = new WorkflowRequestTableField();
        workflowRequestTableField.setFieldName(name);
        workflowRequestTableField.setFieldValue(value);
        workflowRequestTableField.setView(true);
        workflowRequestTableField.setEdit(true);
        return workflowRequestTableField;
    }
}
