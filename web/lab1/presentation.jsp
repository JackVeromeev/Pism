<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 14/03/17
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=Unicode" language="java" %>
<%
    String name = request.getParameter("name");
    String author = request.getParameter("author");
    String year = request.getParameter("year");
    String genre = request.getParameter("genre");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        table {
            border: 2px solid #0b2435;
        }
        .table-head {
            font-size: large;
            background-color: darkcyan;
            color: #FFF;
        }
        td {
            padding:5px;
        }
    </style>
    <title>Result!</title>
</head>
<body>
    <h2>Result</h2>
    <table>
        <tr class="tablehead">
            <td>Field</td>
            <td>Property</td>
        </tr>
        <tr>
            <td>Name</td>
            <td><%=name%></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><%=author%></td>
        </tr>
        <tr>
            <td>Year</td>
            <td><%=year%></td>
        </tr>
        <tr>
            <td>Genre</td>
            <td><%=genre%></td>
        </tr>
    </table>

</body>
</html>
