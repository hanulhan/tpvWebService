<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Welcome</title>
        <!--
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/css/style.css"/>
        -->
    </head>
    <body>
        <h1>Philips TV</h1>
        <h2>${message}</h2>


        <!--   
        <a href="${pageContext.request.contextPath}/tvList">TV List</a>  
        -->

        <button value="Refresh Page" onClick="window.location.reload()">Refresh</button>
        <br>
        <br>

        <div>
            <table border="1">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>IP Address</th>
                    <th>Power state</th>
                    <th>TV Model</th>
                </tr>
                <c:forEach  items="${tvList}" var ="tv">
                    <tr>
                        <td>${tv.tvUniqueID}</td>
                        <td>${tv.tvRoomID}</td>
                        <td>${tv.tvIPAddress}</td>
                        <td>${tv.powerStatus}</td>
                        <td>${tv.tvModel}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>


        <form action="<c:url value="/test" />" method="POST">
            <input type="submit" name="action" value="save" />
        </form>



    </body>


</html>
