<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bookList" scope="request" type="java.util.List"/>
<html>
<body>
    <table>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.bid}</td>
                <td>${book.bname}</td>
                <td>${book.bprice}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
    