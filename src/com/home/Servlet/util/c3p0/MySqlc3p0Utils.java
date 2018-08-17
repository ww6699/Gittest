package com.home.Servlet.util.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class MySqlc3p0Utils {
    private static ComboPooledDataSource ds = new ComboPooledDataSource("mysql");
    public static DataSource getDataSources(){
        return ds;
    }
    public static Connection getConn(){
        try {
            System.out.println("获得连接。。。");
            return ds.getConnection();
          } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
