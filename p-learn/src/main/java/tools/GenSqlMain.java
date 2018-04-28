package tools;

/**
 * Created by qinwanxin on 2017/7/24.
 */
public class GenSqlMain {
    public static void main(String[] args) {
        String tokenuser = "ALTER TABLE `token_user_s%` ADD COLUMN `callerInfo`  varchar(255) NULL COMMENT '操作调用方信息' AFTER `status`;";

        String tokenuserop = "ALTER TABLE `tokenuser_operate_s%`ADD COLUMN `callerInfo`  varchar(255) NULL COMMENT '操作调用方信息' AFTER `remark`;";

        String tokenop = "ALTER TABLE `tokenoperate_s%` ADD COLUMN `callerInfo`  varchar(255) NULL COMMENT '操作调用方信息' AFTER `remark`;";

        for (int i = 0; i < 8; i++) {
            System.out.println("=====================db "+i+"start=====================");
            for(int j=0;j<16;j++){
                System.out.println("ALTER TABLE `tokenoperate_"+(j+16*i)+"` ADD COLUMN `callerInfo`  varchar(255) NULL COMMENT '操作调用方信息' AFTER `remark`;");

            }
            for (int k=0;k<128;k++){
                System.out.println("ALTER TABLE `tokenuser_operate_"+(k+128*i)+"` ADD COLUMN `callerInfo`  varchar(255) NULL COMMENT '操作调用方信息' AFTER `remark`;");
            }
            for (int k=0;k<128;k++){
                System.out.println("ALTER TABLE `token_user_"+(k+128*i)+"` ADD COLUMN `callerInfo`  varchar(255) NULL COMMENT '操作调用方信息' AFTER `status`;");

            }

            System.out.println("=====================db "+i+"end=====================");
        }
        System.out.println();
    }
}
