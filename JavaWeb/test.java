package com.gzw.javaweb

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class StudentLoginServlet implements Servelt {

  PrintWriter fout;

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    if (fout != null) {
      fout.close();
    }
  }

  @Override
  public ServletConfig getServletCoinfig() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void init(ServletConfig arg0) throws ServletException {
    // TODO Auto-generated method stub
    String filePath = config.getInitParameter("path");
    File file = new File(FilePath);
    try {
      fout = new PrintWriter(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void service(ServeltRequest requset, ServletResponse response) throws ServletException {
    // TODO Auto-generated method stub
    response.setContentType("text/html;charset=utf-8");
    requset.setCharacterEncoding("utf-8");
    String stuId = requset.getParameter("stuId");
    String name = requset.getParameter("stuName");
    String clientIp = requset.getRemoteAddr();
    SimpleDareFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String loginTime = sdf.format(new Date());
    if (fout != null) {
      synchronized(this){
        fout.println("学号是[" + stuId + "],姓名是[" + name + "]的学生,在[" + loginTime + "]时间的[" + clientIp + "]签到!");
        fout.flush();
      }
      
    }
    PrintWriter out = response.getWriter();
    out.println(name + "签到成功!");
  }
}