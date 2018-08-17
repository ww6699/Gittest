package com.home.Servlet.Server.user;


import Dao.IBaseDao;
import Dao.user.UserDaoImpl;
import com.home.Servlet.Bean.UserBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements IBaseService<UserBean> {
        private IBaseDao<UserBean> user = new UserDaoImpl();

        @Override
        public int insertInfo(UserBean userBean) {
            try {
                int flg = user.insertData(userBean);
                if (flg == 1) {
                    return 1;//成功
                } else {
                    return 0;//失败
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        @Override
        public  int deleteInfo(UserBean userBean){
            return 0;
        }
        @Override
        public  int updateInfo(UserBean userBean){
            return 0;
        }
        @Override
        public List<Map>selectAll(UserBean userBean){
           try{
               return user.selectAll(userBean);
           }catch (Exception e){
               e.printStackTrace();
           }
           return null;
        }
        @Override
        public  UserBean selectOne(UserBean userBean){
            return null;
        }
    }
