<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 我秀任我秀
  Date: 2021/11/7
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <%
      // 获取当前时间戳
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
      String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
      date = URLEncoder.encode(date, "utf-8");

      Cookie[] cookies = request.getCookies();
      String prevTime = null;
      if (cookies != null && cookies.length > 0){
        for (Cookie cookie : cookies) {
          if ("prevTime".equals(cookie.getName())){
            prevTime = URLDecoder.decode(cookie.getValue(), "utf-8");
          }
        }
      }
      if (prevTime != null ){
        // 说明不是第一次登陆
        response.getWriter().write("<h1>上一次访问时间为：" + prevTime + "</h1>");
      }else {
        // 说明是第一次登陆
        response.getWriter().write("<h1>你好，欢迎您首次访问</h1>");
      }
      Cookie cookie = new Cookie("prevTime", date);
      response.addCookie(cookie);
    %>
  </body>
</html>
