DROP TABLE IF EXISTS kyc_result;
CREATE TABLE `kyc_result` (
  `id` bigint(21) NOT NULL AUTO_INCREMENT,
  `snapshot_id` varchar(50)  NOT NULL COMMENT 'snapshotid',
  `version` varchar(50)  NOT NULL COMMENT 'kyc version',
  `reference_id` varchar(50)  NOT NULL COMMENT 'order/application id',
  `original_result` varchar(10)  DEFAULT NULL COMMENT '机审结果',
  `final_result` varchar(10)  DEFAULT NULL COMMENT 'kyc最终结果',
  `create_timestamp` bigint(20) NOT NULL,
  `update_timestamp` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_snapshot_id` (`snapshot_id`)
)     COMMENT='kyc结果表';

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `addr` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  `cities` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- insert into kyc_result (snapshot_id, version, reference_id) values ('a', 'v', 'ss');