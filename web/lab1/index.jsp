<%@ page import="com.rudko.pism.common.Constants" %><%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 14/03/17
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form</title>
</head>
<body>
    <h1>Book</h1>
    <form name="bookForm" action="presentation.jsp" method="POST">
        <table border="0">
            <tbody>
            <tr>
                <td> Name : </td>
                <td><input type="text" name="name" value="" size="50" /></td>
            </tr>
            <tr>
                <td> Author : </td>
                <td><input type="text" name="author" value="" size="50" /></td>
            </tr>
            <tr>
                <td> Year : </td>
                <td><input type="int" name="year" value="YYYY" size="4" /></td>
            </tr>

            <tr>
                <td> Genre : </td>
                <td><input type="text" name="genre" value="" size="20" /></td>
            </tr>
            </tbody>
        </table>
        <input type="reset" value="Clear" name="Clear" />
        <input type="submit" value="Submit" name="Submit" />
    </form>
</body>
</html>
