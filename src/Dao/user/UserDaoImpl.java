package Dao.user;

import Dao.IBaseDao;
import com.home.Servlet.Bean.UserBean;
import com.home.Servlet.util.c3p0.MySqlc3p0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements IBaseDao<UserBean>{
    Connection connection=MySqlc3p0Utils.getConn();
    PreparedStatement preparedStatement=null;
    @Override
    public int insertData(UserBean userBean) throws SQLException {
        String string="insert into user(userName,password,sex,age,IDcard) values(?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(string);
        try {
            preparedStatement.setString(1,userBean.getUserName());
            preparedStatement.setString(2,userBean.getPassword());
            preparedStatement.setString(3,userBean.getSex());
            preparedStatement.setInt(4,userBean.getAge());
            preparedStatement.setString(5,userBean.getIDcard());
            int i=preparedStatement.executeUpdate();
            if (i!=0){
                System.out.println("注册成功");
                return 1;
            }else {
                System.out.println("注册失败");
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteData(UserBean userBean) {
        return 0;
    }

    @Override
    public List<Map> selectAll(UserBean userBean) throws SQLException {
        return null;
    }

    @Override
    public UserBean selectOne(UserBean userBean) throws SQLException {
        return null;
    }

    @Override
    public int updateData(UserBean userBean) {
        return 0;
    }

}
