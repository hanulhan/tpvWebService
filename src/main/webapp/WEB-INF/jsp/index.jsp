<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/layout.css" rel="stylesheet" />
        <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
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

    </div>
    <br>
    <br>
    <div class="col-md-3">
        <select id="selTV" name="selTV" class="input-sm" required="" >Select TV</select>
    </div>
    <br>
    <br>

    <form action="<c:url value="/test" />" method="POST">
        <input type="submit" name="action" value="save" />
    </form>



</body>
<script type="text/javascript">
    var sDateFormat = "<s:text name='global.dateformat.long'/>";

    $(document).ready(function () {
       console.log("document.ready()");
       var el= document.getElementById('selTV');
       <c:forEach  items="${tvList}" var ="tv">
          var opt= document.createElement('option');
          opt.innerHTML= "${tv.tvUniqueID}";
          opt.value= "${tv.tvUniqueID}";
          selTV.appendChild(opt);
       </c:forEach>        
        
        
    });
</script>

</html>
