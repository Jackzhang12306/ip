<%@ page language="java" import="com.cetc.bean.IpBean"  import="java.util.List" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#ip
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#ip td, #ip th 
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#ip th 
  {
  font-size:1.1em;
  text-align:left;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }

#ip tr.alt td 
  {
  color:#000000;
  background-color:#EAF2D3;
  }
</style>
</head>

<body>

<h3 align="center" >IP列表</h3>
    <table border="1" width="70%" align="center" id="ip">
        <tr>
            <th>用户姓名</th>
            <th>ip地址</th>
            <th>是否使用</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
			 <c:set var="index" value="1"/>
        
        <c:forEach items="${list}" var="cstm">
        		
        <c:set var="cla" value=" "/>
        <c:set var="index" value="${index+1}"/>
        <c:if test="${index%2==0}">
          <c:set var="cla" value="alt"/>
    			</c:if>
    
        <tr class="${cla}">
            <td>${cstm.username}</td>
            <td>${cstm.ip}</td>
            <td>${cstm.used}</td>
            <td>${cstm.decription}</td>
            <td>${cstm.decription}</td>
        </tr>
        </c:forEach>
    </table>
<br/>
</body>
</html>

