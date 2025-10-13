package com.leisure.basic;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ClassName: Test
 * Package: com.leisure.basic
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2025/10/5:19:48:48 星期日
 */
public class Test {
    //SqlLite数据库名称
    public static final String DATABASE_NAME = "lottery";
    //SqlLite数据库版本号
    public static final int DATABASE_VERSION = 1;
    //SqlLite数据库的表名
    public static final String TABLE_NAME = "record";
    //数据库驱动
    public static final String Driver = "com.mysql.jdbc.Driver";
    //数据库地址
    public static final String URL = "jdbc:mysql://127.0.0.1:3305/lottery?useUnicode=true&characterEncoding=UTF-8";
    //数据库用户名
    public static final String USER = "root";
    //数据库密码
    public static final String PASSWORD = "123456";

    public static void main(String[] args) {

        Connection con;
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" 数据库连接成功了。。。。。");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

}

