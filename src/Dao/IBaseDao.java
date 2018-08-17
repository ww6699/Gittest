package Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {

    //add
    int insertData(T t) throws SQLException;
    //delete
    int deleteData(T t) throws SQLException;
    //select(all)
    List<Map>selectAll(T t) throws SQLException;
    //select(one)
    T selectOne(T t) throws SQLException;
    //update
    int updateData(T t);
}
