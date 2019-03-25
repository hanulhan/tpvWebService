<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Person List</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <h1>TV List</h1>

        <br/><br/>
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
    </body>

</html>
