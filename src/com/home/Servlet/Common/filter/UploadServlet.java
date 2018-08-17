package com.home.Servlet.Common.filter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UploadServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断文件存储路径是否存在
        String savaPath = this.getServletContext().getRealPath("/upload");
        File file = new File(savaPath);
        if (file.exists() && !file.isDirectory()) { //判断文件是否存在和文件是否为文件夹
            file.mkdir();
        }
        //appach文件上传流程：
        //创建工厂（DiskFileItemUpload）
        DiskFileItemFactory disk = new DiskFileItemFactory();

        //创建文件解析器（ServletFileUpload）
        ServletFileUpload servletF = new ServletFileUpload(disk);

        //设置编码
        servletF.setHeaderEncoding("UTF-8");
        //判断数据是否为表单数据
        if (!servletF.isMultipartContent(req)) {
            return;
        }
        //ServletFileUpload praseRequest处理为List<fileItem>
        try {
            List<FileItem> list = servletF.parseRequest(req);
            for (FileItem item : list) {
                if (!item.isFormField()) {
                    //获取文件名字
                    String filename=item.getName();
                    //保存原来名字
                    String oldName=filename.substring(filename.lastIndexOf("\\")+1);

                    String fileName = item.getName();
                    if (fileName == null || fileName.isEmpty()) {
                        continue;
                    }
                    fileName =new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
                    //获取一个输入流
                    InputStream inputStream=item.getInputStream();
                    //开启一个输出流
                    FileOutputStream fileO=new FileOutputStream(savaPath + "\\" + fileName);

                    byte[] bytes=new byte[2048];
                    int len=0;
                    while ((len = inputStream.read(bytes))>0){
                        fileO.write(bytes,0,len);
                    }
                    inputStream.close();
                    fileO.close();
                    item.delete();
                    resp.getWriter().print(savaPath + "\\" +fileName);
                }
            }


        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
