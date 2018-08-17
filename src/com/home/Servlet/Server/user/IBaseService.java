package com.home.Servlet.Server.user;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> {
    //add
    int insertInfo(T t);
    //delete
    int deleteInfo(T t);
    //update
    int updateInfo(T t);
    //select(all)
    List<Map> selectAll(T t);
    //select(One)
    T selectOne(T t);
}
