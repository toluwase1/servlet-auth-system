<%--
  Created by IntelliJ IDEA.
  User: onagssy
  Date: 10/05/2021
  Time: 7:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div align ="center">
    <h1>User Login Form</h1>
    <form action ="login" method="post">
        <table>

            <tr><td>Email: </td><td><input type="email" name="email"></td></tr>
            <tr><td>Password: </td><td><input type="password" name="password"></td></tr>

            <tr><td></td><td><input type="submit" value="Submit"></td></tr>
        </table>


    </form>

</div>
</body>
</html>
