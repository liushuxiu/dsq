package com.uestc.miaoshi;


import com.uestc.miaoshi.model.CreditApplication;
import com.uestc.miaoshi.model.UserAdditionalInfo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

public class DataInsert {
    public static void main(String[] args) {
        try {
            //准白sql语句
            String sql = "INSERT INTO user_additional_info (id, user_id, status, material_type, expire_date) VALUES(?,?,?,?, ?)";
            String sql2 = "INSERT INTO credit_application (id, channel, sequence_id, create_timestamp, update_timestamp, type, user_id, user_info_id, status, application_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            Connection con = null;
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取到远程服务器的连接
            con = DriverManager.getConnection("jdbc:mysql://192.168.133.69:3306/nkp?useUnicode=true&"+
                            "characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true",
                    "admin","password1234");
            //设置非自动提交事务
            con.setAutoCommit(false);
            PreparedStatement pstat = con.prepareStatement(sql);
            PreparedStatement pstat2 = con.prepareStatement(sql2);
            int number = 0;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());


            String statusArr[] = new String[] {"AUDITTING", "EXPIRED"};
            String types [ ] = new String[]{"SIM", "DRIVING_LICENSE", "LAST_2_MONTH_SALARY_SLIPS", "CERTIFICATE_OF_REAL_ESTATE", "test-other"};
            String channels [] = new String[] {"channelA", "channelB", "OFFLINE_SALES"};
            Random r = new Random();
            List<UserAdditionalInfo> infos = new ArrayList< >();
            for (int i = 0; i < 300000; i++) {
                UserAdditionalInfo info = new UserAdditionalInfo();
                info.setId("AA" + i);
                info.setUserId("USERID" + i);
                info.setCreateTimestamp(new Date());
                number = r.nextInt(5);
                info.setMaterialType(types[number%5]);
                info.setStatus(statusArr[number%2]);
                infos.add(info);
            }


            List<String> allUsers = infos.stream().map(p -> p.getUserId()).collect(Collectors.toList());

            List<String> userIds = infos.stream().filter(p -> p.getStatus().equals("AUDITTING") && !p.getMaterialType().equals("test-other")).map(p -> p.getUserId()).
                    collect(Collectors.toList());


            List<CreditApplication> applications = new ArrayList<>();
            for (int i = 0; i < 900000 ; i++) {
                CreditApplication application = new CreditApplication();
                application.setId("BB"+i);
                application.setApplicationId("BB" + i);
                number = r.nextInt(3);
                application.setChannel(channels[number%3]);
                application.setSequenceId(i);
                number = r.nextInt(60);
                calendar.set(Calendar.MINUTE, number);
                number = r.nextInt(60);
                calendar.set(Calendar.SECOND, number);
                application.setCreateTimestamp(calendar.getTime());
                application.setUpdateTimestamp(calendar.getTime());
                application.setType("Typessss");

                application.setUserId(allUsers.get(i % allUsers.size()));

                application.setUserInfoId("UserInfoId");
                application.setStatus("testStatus");
                applications.add(application);
            }
           String sql3 = "INSERT INTO credit_application (id, channel, sequence_id, create_timestamp, update_timestamp, type, user_id, user_info_id, status,application_id) VALUES(?,?,?,?,?,?,?,?,?,?)";


            for (int i =0;i<applications.size();i++) {
                CreditApplication application = applications.get(i);
                pstat2.setString(1, application.getId());
                pstat2.setString(2, application.getChannel());
                pstat2.setInt(3, application.getSequenceId());
                pstat2.setDate(4, new java.sql.Date(application.getCreateTimestamp().getTime()));
                pstat2.setDate(5, new java.sql.Date(application.getUpdateTimestamp().getTime()));
                pstat2.setString(6, application.getType());
                pstat2.setString(7, application.getUserId());
                pstat2.setString(8, application.getUserInfoId());
                pstat2.setString(9, application.getStatus());
                pstat2.setString(10, application.getApplicationId());

                //10w提交一次
                pstat2.addBatch();
                if(i % 100000 == 0){
                    pstat2.executeBatch();
                    pstat2.clearBatch();
                }
            }


            for (int i =0;i<infos.size();i++) {
                UserAdditionalInfo info = infos.get(i);
                pstat.setString(1, info.getId());
                pstat.setString(2, info.getUserId());
                pstat.setString(3, info.getStatus());
                pstat.setString(4, info.getMaterialType());
                pstat.setString(5, info.getExpireDate());
                //10w提交一次
                pstat.addBatch();
                if(i % 100000 == 0){
                    pstat.executeBatch();
                    pstat.clearBatch();
                }
            }

            pstat.executeBatch(); //执行批处理
            pstat.clearBatch();  //清空批处理
            pstat2.executeBatch(); //执行批处理
            pstat2.clearBatch();  //清空批处理
            con.commit();
            long end = System.currentTimeMillis();
            pstat.close();
            con.close();
//            System.out.print((end-start)/1000+"秒。");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}


