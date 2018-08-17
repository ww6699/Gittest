package com.home.Servlet.servlet;

import Dao.IBaseDao;
import com.home.Servlet.Bean.UserBean;
import com.home.Servlet.Server.user.IBaseService;
import com.home.Servlet.Server.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static com.home.Servlet.util.MapUtil.mapToObject;
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
        IBaseService<UserBean> ib=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("GBK");
        UserBean userBean=new UserBean();
        Map param = new HashMap();
        Enumeration<String> keys = req.getParameterNames();//取出所有的key值
        while (keys.hasMoreElements()){//遍历所有的key
            String key = keys.nextElement();
            //req.getParameter("sex")
            param.put(key, req.getParameter(key));

        }
        try {
            userBean = (UserBean) mapToObject(param, UserBean.class);//map转换为bean对象，原理类反射

            //出参 = 方法名（入参，入参2）；

        } catch (Exception e) {
            e.printStackTrace();
        }

        Integer flg = ib.insertInfo(userBean);
        PrintWriter out = resp.getWriter();

        if("1".equals(flg.toString())){
            //out.print("成功")
            //System.out.println("注册成功");
            resp.sendRedirect("/user/Login.html");
        }else{
            out.print("失败");
        }


    }
}
