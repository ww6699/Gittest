package com.home.Servlet.util.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil_BO {
    public Connection connection=null;
    public PreparedStatement preparedStatement=null;
    public ResultSet resultSet=null;
    public Integer integer=null;
    public DBUtil_BO(){
        super();
    }
}
