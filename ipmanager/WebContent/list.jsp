<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.cetc.bean.*" %>
<%@ page import="com.cetc.util.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message List</title>
</head>
<body>
<% 
   //控制层MessageList类传递来分页数据
	   IpBean p=(IpBean)request.getAttribute("");
	   ArrayList<IpBean> list=(ArrayList<IpBean>)request.getAttribute("list");
	   int id=0;
    %>	
    <table width="770" border=1 cellpadding=0 cellspacing=0 align="center">
	<caption>
	    <h2>留言本</h2>
        <!--分页导航超链接-->
        <%=p.pageLegend() %>	
	</caption>
	<tr>
            <th width="6%">序号</th>
            <th width="8%">账号</th>
            <th width="20%">标题</th>
            <th width="40%">内容</th>
            <th width="20%">时间</th>
            <th width="8%">操作</th>
	</tr>
	<%for(Message m:list){%>
	<tr>
            <td><%=++id%></td>
            <td><%=m.getUsername()%></td>
            <td><a href="msg?id=<%=m.getId()%>"><%=m.getTitle()%></a></td>
            <td>
                <%
                    //内容字段最多显示16个字符
                    if(m.getContent().length()<=16)  out.print(m.getContent());
                    else  out.print(m.getContent().substring(0, 16)+"...");
                %>
            </td>
            <td><%=m.getAddtime()%></td>
            <td><a href="msg?id=<%=m.getId()%>">查看</a></td>
	</tr>
	<%}%>
    </table>
    <br/>
    <div align="center">
    <a href="add.jsp">我要留言</a>&nbsp;&nbsp;
    <% 
    	String username=(String)session.getAttribute("username"); 
    	if(username==null || username==""){
    		out.println("<a href='login.jsp'>用户登录</a>&nbsp;&nbsp;");
    		out.println("<a href='regist.jsp'>用户注册</a>");
    	}else
    		out.print(username+"已经登录");
    %>	        
    </div>
</body>
</html> --%>