CREATE TABLE t_workflow_log(
  id int(11) NOT NULL AUTO_INCREMENT ,
  request_id varchar(64) NOT NULL COMMENT '请求ID',
  user_id varchar(16) NOT NULL COMMENT '用户ID',
  workflow_id varchar(16) NOT NULL COMMENT '流程ID',
  workflow_name varchar(64) DEFAULT NULL COMMENT '流程名',
  status varchar(16) DEFAULT NULL COMMENT 'NEW, REJECT, COMPLETE',
  retry_time int(11) DEFAULT 0 COMMENT '重试次数',
  retry_max_time int(11) DEFAULT 3 COMMENT '最大次数',
  PRIMARY KEY (id)
);
