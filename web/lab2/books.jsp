<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CS
  Date: 22.02.2017x
  Time: 5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*
    * get status
    */
    String status = request.getParameter("status");
    if(status == null || "null".equals(status   )) status = "";
    else status = "<p>" + status + "</p>";

%>
<html>
    <head>
        <title>Book list</title>
        <style>
            table {
                border: 2px solid #0b2435;
                margin: 7px;
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
    </head>
    <body>
        <p>List of my books</p>

        <table border="1">
            <tr class="table-head">
                <td>#</td>
                <td>Name</td>
                <td>Author</td>
                <td>Year</td>
                <td>del</td>
            </tr>
            <c:forEach items="${requestScope.books}" var="book">
                <tr>

                    <td>${book.id + 1}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.year}</td>
                    <td>
                        <form action="lab2?id=${book.id}" method="post">
                            <input type="hidden" value="${book.id}" name="id">
                            <input type="hidden" value="del" name="action">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <p>Add a book</p>
        <form action="lab2" method="post">
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
                    <td><input type="number" name="year" value="YYYY" size="4" /></td>
                </tr>
                </tbody>
            </table>
            <input type="hidden" value="add" name="action">
            <input type="reset" value="Clear" name="Clear" />
            <input type="submit" value="Add" name="Add" />
        </form>
        <%=status%>
    </body>
</html>