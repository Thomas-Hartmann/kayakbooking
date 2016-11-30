<%-- 
    Document   : showbookings
    Created on : Nov 30, 2016, 9:52:16 AM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, control.Booking" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>
        <table class="table table-striped">
            <tr><th>Date</th><th>Kayak</th><th>Booked by</th></tr>
            <c:if test="${sessionScope.msg != null}"><h1>${sessionScope.msg}</h1></c:if>
                    <c:forEach items="${sessionScope.bookings}" var="booking">
                <tr>
                    <fmt:formatDate value="${booking.date}" var="bookingdate" 
                type="date" pattern="dd-MM-yyyy" />
                    <td col-md-1>${bookingdate}</td><td col-md-2>${booking.kayak.name}</td><td col-md-2>${booking.user.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
