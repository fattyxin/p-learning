package collection;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

/**
 * Created by qinwanxin on 2018/1/18.
 */
public class TestMain {
    public static void main(String[] args) {
        genSql();
    }

    private static void testNullValueMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", null);
        map.put("2", null);
        System.out.println("map.values() = " + map.values());
        System.out.println("map.values().size() = " + map.values().size());
        for (String v : map.values()) {
            System.out.println("v = " + v);
        }
        if (map.values().contains(null)) {
            Set<String> s = new HashSet<String>();
            s.addAll(map.values());
            System.out.println("s.size() = " + s.size());
            System.out.println("(s.size()>1 = " + (s.size() > 1));
        }

        map.values().remove(null);
        System.out.println("map.size() = " + map.size());

        System.out.println("123456".hashCode());
        System.out.println("123!@#".hashCode());

    }

    private static void doWhileTest() {
        int retry = 0;

        do {
            try {
                throw new RuntimeException("cuocuocuo");

            } catch (Exception e) {
                System.out.println("retry = " + retry);
                retry++;
            }
        } while (retry <= 3);
        System.out.println("end");
    }

    private static void genSql() {
        int dbNum = 64;
        int tbNumPerDb = 256;
        try {
//            FileOutputStream fos = new FileOutputStream("C:\\Users\\qinwanxin\\Desktop\\sql.txt");

            for (int dbindex = 1; dbindex <= dbNum; dbindex++) {
                List<String> dbsqls = new ArrayList<String>();

//                dbsqls.add("use database promotion_" + dbindex + " ;");
//                dbsqls.add("CREATE TABLE `promotion_status_task` ( `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号', `PromoId` bigint(20) NOT NULL DEFAULT '0' COMMENT '促销编号', `PromoType` int(5) NOT NULL DEFAULT '0' COMMENT '促销类型(单品=1/赠品=4/总价=10/套装=6/附件=5)', `OperateType` int(5) NOT NULL DEFAULT '0' COMMENT '操作类型(新增=0/修改=1/删除=2)', `TaskStatus` int(5) NOT NULL DEFAULT '0' COMMENT '任务状态(初始化=0/成功=1/失败=2)', `RetriesNumber` tinyint(1) NOT NULL DEFAULT '0' COMMENT '重试次数(默认为0，失败或者成功后加1)', `PromoData` varchar(1024) DEFAULT NULL, `VersionNumber` int(1) NOT NULL DEFAULT '0' COMMENT '版本号(默认为0，更新成功后加1)', `Remark` varchar(256) DEFAULT NULL COMMENT '备注(默认为空)', `CreateTime` datetime NOT NULL COMMENT '创建时间', `ModifyTime` datetime NOT NULL COMMENT '修改时间', PRIMARY KEY (`id`), KEY `idx_promoid` (`PromoId`), KEY `idx_taskstatus_created_retrynum` (`TaskStatus`,`CreateTime`,`RetriesNumber`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销活动状态任务表';");
//                dbsqls.add("CREATE TABLE `taskmain_b_1` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Promotype` smallint(6) DEFAULT NULL COMMENT '促销类型', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `RetryNum` smallint(6) DEFAULT NULL COMMENT '任务重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `TaskType` smallint(6) DEFAULT NULL COMMENT '发布 删除 暂停 启动', `WebSite` smallint(6) DEFAULT NULL COMMENT '站点', `ExcTime` datetime DEFAULT NULL COMMENT '任务执行时间', `ExtType` smallint(6) DEFAULT NULL COMMENT '任务执行类别', `BatchId` bigint(20) DEFAULT '0', PRIMARY KEY (`Id`), KEY `idx_created` (`Created`), KEY `idx_state_retrynum_created` (`State`,`Created`,`RetryNum`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销发布主任务';");
//                dbsqls.add("CREATE TABLE `taskmain_b_2` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Promotype` smallint(6) DEFAULT NULL COMMENT '促销类型', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `RetryNum` smallint(6) DEFAULT NULL COMMENT '任务重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `TaskType` smallint(6) DEFAULT NULL COMMENT '发布 删除 暂停 启动', `WebSite` smallint(6) DEFAULT NULL COMMENT '站点', `ExcTime` datetime DEFAULT NULL COMMENT '任务执行时间', `ExtType` smallint(6) DEFAULT NULL COMMENT '任务执行类别', `BatchId` bigint(20) DEFAULT '0', PRIMARY KEY (`Id`), KEY `idx_created` (`Created`), KEY `idx_state_retrynum_created` (`State`,`Created`,`RetryNum`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销发布主任务';");
//                dbsqls.add("CREATE TABLE `tasksecmain_1` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号', `MainTaskId` bigint(20) NOT NULL DEFAULT '0', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Promotype` smallint(6) DEFAULT NULL COMMENT '促销类型', `Dbindex` varchar(20) DEFAULT NULL, `TableIndex` smallint(6) DEFAULT NULL COMMENT '表', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `RetryNum` smallint(6) DEFAULT NULL COMMENT '任务重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `TaskType` smallint(6) DEFAULT NULL COMMENT '发布 删除 暂停 启动', `WebSite` smallint(6) DEFAULT NULL COMMENT '站点', `ExcTime` datetime DEFAULT NULL COMMENT '任务执行时间', `ExtType` smallint(6) DEFAULT NULL COMMENT '任务执行类别', `BatchId` bigint(20) DEFAULT NULL, `redisGroup` int(11) DEFAULT NULL, PRIMARY KEY (`Id`) ) ENGINE=InnoDB AUTO_INCREMENT=1921 DEFAULT CHARSET=utf8 COMMENT='促销发布二级主任务';");
//                dbsqls.add("CREATE TABLE `tasksecmain_2` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号', `MainTaskId` bigint(20) NOT NULL DEFAULT '0', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Promotype` smallint(6) DEFAULT NULL COMMENT '促销类型', `Dbindex` varchar(20) DEFAULT NULL, `TableIndex` smallint(6) DEFAULT NULL COMMENT '表', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `RetryNum` smallint(6) DEFAULT NULL COMMENT '任务重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `TaskType` smallint(6) DEFAULT NULL COMMENT '发布 删除 暂停 启动', `WebSite` smallint(6) DEFAULT NULL COMMENT '站点', `ExcTime` datetime DEFAULT NULL COMMENT '任务执行时间', `ExtType` smallint(6) DEFAULT NULL COMMENT '任务执行类别', `BatchId` bigint(20) DEFAULT NULL, `redisGroup` int(11) DEFAULT NULL, PRIMARY KEY (`Id`) ) ENGINE=InnoDB AUTO_INCREMENT=1921 DEFAULT CHARSET=utf8 COMMENT='促销发布二级主任务';");
//                dbsqls.add("CREATE TABLE `tasksecmain_3` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号', `MainTaskId` bigint(20) NOT NULL DEFAULT '0', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Promotype` smallint(6) DEFAULT NULL COMMENT '促销类型', `Dbindex` varchar(20) DEFAULT NULL, `TableIndex` smallint(6) DEFAULT NULL COMMENT '表', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `RetryNum` smallint(6) DEFAULT NULL COMMENT '任务重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `TaskType` smallint(6) DEFAULT NULL COMMENT '发布 删除 暂停 启动', `WebSite` smallint(6) DEFAULT NULL COMMENT '站点', `ExcTime` datetime DEFAULT NULL COMMENT '任务执行时间', `ExtType` smallint(6) DEFAULT NULL COMMENT '任务执行类别', `BatchId` bigint(20) DEFAULT NULL, `redisGroup` int(11) DEFAULT NULL, PRIMARY KEY (`Id`) ) ENGINE=InnoDB AUTO_INCREMENT=1921 DEFAULT CHARSET=utf8 COMMENT='促销发布二级主任务';");
//                dbsqls.add("CREATE TABLE `tasksecmain_4` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号', `MainTaskId` bigint(20) NOT NULL DEFAULT '0', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Promotype` smallint(6) DEFAULT NULL COMMENT '促销类型', `Dbindex` varchar(20) DEFAULT NULL, `TableIndex` smallint(6) DEFAULT NULL COMMENT '表', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `RetryNum` smallint(6) DEFAULT NULL COMMENT '任务重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `TaskType` smallint(6) DEFAULT NULL COMMENT '发布 删除 暂停 启动', `WebSite` smallint(6) DEFAULT NULL COMMENT '站点', `ExcTime` datetime DEFAULT NULL COMMENT '任务执行时间', `ExtType` smallint(6) DEFAULT NULL COMMENT '任务执行类别', `BatchId` bigint(20) DEFAULT NULL, `redisGroup` int(11) DEFAULT NULL, PRIMARY KEY (`Id`) ) ENGINE=InnoDB AUTO_INCREMENT=1921 DEFAULT CHARSET=utf8 COMMENT='促销发布二级主任务';");
//                dbsqls.add("CREATE TABLE `tasksub_b_1` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '子任务编号', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `PromoType` smallint(6) DEFAULT NULL COMMENT '促销类型', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `TaskType` smallint(6) DEFAULT NULL COMMENT '任务类型', `RetryNum` smallint(6) DEFAULT NULL COMMENT '重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `InfoKey` varchar(100) DEFAULT NULL COMMENT 'key值', `MainTaskId` bigint(20) DEFAULT NULL COMMENT '主任务编号', `SubKey` varchar(100) DEFAULT NULL COMMENT '子任务key', `ScopeType` int(11) DEFAULT NULL COMMENT '促销选品类型', `ScopeValue` varchar(100) DEFAULT NULL COMMENT '任务选品值', `centerName` varchar(20) DEFAULT NULL COMMENT '中心名称', `BatchId` bigint(20) DEFAULT NULL COMMENT '批次号', PRIMARY KEY (`Id`), KEY `idx_mainTaskId` (`MainTaskId`), KEY `idx_created_state_retrynum` (`State`,`Created`,`RetryNum`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销子任务表';");
//                dbsqls.add("CREATE TABLE `tasksub_b_2` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '子任务编号', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `PromoType` smallint(6) DEFAULT NULL COMMENT '促销类型', `State` smallint(6) DEFAULT NULL COMMENT '任务状态', `TaskType` smallint(6) DEFAULT NULL COMMENT '任务类型', `RetryNum` smallint(6) DEFAULT NULL COMMENT '重试次数', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `InfoKey` varchar(100) DEFAULT NULL COMMENT 'key值', `MainTaskId` bigint(20) DEFAULT NULL COMMENT '主任务编号', `SubKey` varchar(100) DEFAULT NULL COMMENT '子任务key', `ScopeType` int(11) DEFAULT NULL COMMENT '促销选品类型', `ScopeValue` varchar(100) DEFAULT NULL COMMENT '任务选品值', `centerName` varchar(20) DEFAULT NULL COMMENT '中心名称', `BatchId` bigint(20) DEFAULT NULL COMMENT '批次号', PRIMARY KEY (`Id`), KEY `idx_mainTaskId` (`MainTaskId`), KEY `idx_created_state_retrynum` (`State`,`Created`,`RetryNum`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销子任务表';");

                for (int tbIndex = 1; tbIndex <= tbNumPerDb; tbIndex++) {
//                 dbsqls.add("CREATE TABLE `area_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `PromoType` int(11) DEFAULT NULL COMMENT '促销类型', `Area` varchar(50) DEFAULT NULL COMMENT '区域编号', `Type` int(11) DEFAULT NULL COMMENT '区域类型', `Remark` varchar(200) DEFAULT NULL COMMENT '备注', `Yn` tinyint(1) DEFAULT NULL COMMENT '是否有效', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `groupId` int(11) DEFAULT '0' COMMENT '区域促销分组编号', PRIMARY KEY (`Id`), KEY `idx_promoid_yn` (`PromoId`,`Yn`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销区域表';");
//                    dbsqls.add("CREATE TABLE `house_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `PromoType` int(11) DEFAULT NULL COMMENT '促销类型', `DcId` varchar(50) DEFAULT NULL COMMENT '配送中心编号', `Sid` varchar(50) DEFAULT NULL COMMENT '库房编号', `YN` tinyint(1) DEFAULT NULL COMMENT '是否有效', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `GroupId` bigint(20) DEFAULT NULL, PRIMARY KEY (`Id`), KEY `idx_promoId` (`PromoId`) USING BTREE ) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='促销库房表';");
//                    dbsqls.add("CREATE TABLE `multirangeproduct_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `GroupId` bigint(20) DEFAULT NULL COMMENT '池号', `GroupType` int(11) DEFAULT NULL COMMENT '组类型', `SkuId` bigint(20) DEFAULT NULL COMMENT '商品编号', `SkuName` varchar(200) DEFAULT NULL COMMENT '商品名称', `Num` int(11) DEFAULT NULL COMMENT '数量', `Price` decimal(19,4) DEFAULT NULL COMMENT '促销创建时京东价', `SplitPrice` decimal(19,4) DEFAULT NULL COMMENT '拆分价', `InPrice` decimal(19,4) DEFAULT NULL COMMENT '进货价', `CBJ` decimal(19,4) DEFAULT NULL COMMENT '仓包价', `YN` tinyint(1) DEFAULT NULL COMMENT '是否有效', `Cfprice` decimal(19,4) DEFAULT NULL COMMENT '创建时返现', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `batchId` bigint(20) DEFAULT '0', `VenderId` bigint(20) DEFAULT NULL COMMENT '商家标识', `State` int(11) DEFAULT '0', `ShowState` tinyint(1) DEFAULT '1', PRIMARY KEY (`Id`), KEY `idx_promoId` (`PromoId`), KEY `idx_skuId` (`SkuId`), KEY `idx_promoId_groupType_skuId_yn` (`PromoId`,`GroupType`,`SkuId`,`YN`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sku选品表';");
//                    dbsqls.add("CREATE TABLE `operateinfo_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `OperateType` int(11) DEFAULT NULL COMMENT '操作类型', `OperateState` int(11) DEFAULT NULL COMMENT '操作状态', `Operator` varchar(50) DEFAULT NULL COMMENT '操作人erp账号', `OperateName` varchar(50) DEFAULT NULL COMMENT '操作人姓名', `OperateTime` datetime DEFAULT NULL COMMENT '操作时间', `Opinion` varchar(400) DEFAULT NULL COMMENT '意见', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `ClientIP` varchar(100) DEFAULT NULL COMMENT 'IP', `Source` smallint(6) DEFAULT NULL COMMENT '来源', `Remark` varchar(200) DEFAULT NULL, PRIMARY KEY (`Id`), KEY `idx_promoid` (`PromoId`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';");
//                    dbsqls.add("CREATE TABLE `preventrewrite_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Rsn` varchar(50) NOT NULL COMMENT '防重入key', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Created` datetime DEFAULT NULL, PRIMARY KEY (`Rsn`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='防重入表';");
//                    dbsqls.add("CREATE TABLE `promotioninfo_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL COMMENT '促销编号', `Type` int(11) DEFAULT NULL COMMENT '促销类型', `ExtType` int(11) DEFAULT NULL COMMENT '促销扩展类型', `RangeType` int(11) DEFAULT NULL COMMENT '商品范围', `TimeBegin` datetime DEFAULT NULL COMMENT '开始时间', `TimeEnd` datetime DEFAULT NULL COMMENT '结束时间', `CheckState` int(11) DEFAULT NULL COMMENT '审核状态', `DeleteState` tinyint(1) DEFAULT NULL COMMENT '删除状态', `PromoState` tinyint(4) DEFAULT NULL COMMENT '促销审批状态', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Source` smallint(6) DEFAULT NULL COMMENT '来源', `Rsn` varchar(50) DEFAULT NULL COMMENT '防重入值', `extTags` varchar(400) DEFAULT NULL COMMENT '可变扩展标签', `Creator` varchar(50) DEFAULT NULL, `CreatorName` varchar(50) DEFAULT NULL, PRIMARY KEY (`Id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销表';");
//                    dbsqls.add("CREATE TABLE `rangecategory_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `GroupId` bigint(20) DEFAULT NULL COMMENT '分组编号-店铺编号，分类编号，供应商编号', `GroupType` int(11) DEFAULT NULL COMMENT '分组类型', `Yn` tinyint(1) DEFAULT NULL COMMENT '是否有效', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Remark` varchar(400) DEFAULT NULL COMMENT '备注', `Category` varchar(100) DEFAULT NULL COMMENT '类目内容', `ShopId` varchar(100) DEFAULT NULL COMMENT '店铺Id ', `batchId` bigint(20) DEFAULT '0', `State` int(11) DEFAULT '0', PRIMARY KEY (`Id`), KEY `idx_promoid` (`PromoId`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目选品表';");
//                    dbsqls.add("CREATE TABLE `rangeproduct_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `GroupId` bigint(20) DEFAULT NULL COMMENT '池号', `GroupType` int(11) DEFAULT NULL COMMENT '组类型', `SkuId` bigint(20) DEFAULT NULL COMMENT '商品编号', `SkuName` varchar(200) DEFAULT NULL COMMENT '商品名称', `Num` int(11) DEFAULT NULL COMMENT '数量', `Price` decimal(19,4) DEFAULT NULL COMMENT '促销创建时京东价', `SplitPrice` decimal(19,4) DEFAULT NULL COMMENT '拆分价', `InPrice` decimal(19,4) DEFAULT NULL COMMENT '进货价', `CBJ` decimal(19,4) DEFAULT NULL COMMENT '仓包价', `YN` tinyint(1) DEFAULT NULL COMMENT '是否有效', `Cfprice` decimal(19,4) DEFAULT NULL COMMENT '创建时返现', `Created` datetime DEFAULT NULL COMMENT '创建时间', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `batchId` bigint(20) DEFAULT '0', `VenderId` bigint(20) DEFAULT NULL COMMENT '商家标识', `State` int(11) DEFAULT '0', `ShowState` tinyint(1) DEFAULT '1', PRIMARY KEY (`Id`), KEY `idx_promoId` (`PromoId`), KEY `idx_skuId` (`SkuId`), KEY `idx_promoId_groupType_skuId_yn` (`PromoId`,`GroupType`,`SkuId`,`YN`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sku选品表';");

                dbsqls.add("CREATE TABLE `content_" + (tbIndex + (dbindex - 1) * tbNumPerDb) + "` ( `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号', `PromoId` bigint(20) DEFAULT NULL COMMENT '促销编号', `Content` text COMMENT '促销内容', `Created` datetime DEFAULT NULL COMMENT '创建时间', `YN` tinyint(1) DEFAULT NULL COMMENT '是否有效', `Modified` datetime DEFAULT NULL COMMENT '修改时间', `Version` varchar(50) DEFAULT NULL COMMENT '版本', `Type` int(11) DEFAULT NULL COMMENT '促销类型', PRIMARY KEY (`Id`), KEY `idx_promoid_yn` (`PromoId`,`YN`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销内容表';");

                }
                FileUtils.writeLines(new File("C:\\Users\\qinwanxin\\Desktop\\dbsql\\" + dbindex + ".sql"), "UTF-8", dbsqls);
                Thread.sleep(2000L);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
