<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">添加IP信息</h3>
<form action="save" method="post">
    <input type="hidden" name="method" value="add">
    <table border="0" align="center" width="40%" style="margin-left: 100px">
        <tr>
            <td width="100px">ip地址</td>
            <td width="40%">
                <input type="text" name="ip"/>
            </td>
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>ip拥有者</td>
            <td width="40%">
                <input type="text" name="username"/>
            </td>
            </tr>
            		<tr>
            		<td>是否使用</td>
            <td>
                <input type="radio" name="used" value="0" id="0"/>
                <label for="0">否</label>
                <input type="radio" name="used" value="1" id="1"/>
                <label for="1">是</label>
            </td>
            <td>
                <label id="genderError" class="error">&nbsp;</label>
            </td>
        </tr>
       
        <tr>
            <td>描述</td>
            <td>
                <textarea rows="5" cols="30" name="description"></textarea>
            </td>
            <td>
                <label id="descriptionError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="submit"/>
                <input type="reset" value="reset"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>