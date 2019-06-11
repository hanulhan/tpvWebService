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

        <style>
            th, td, p, input {
                font: 14px Verdana;
            }
            table, th, td {
                border: solid 1px #DDD;
                border-collapse: collapse;
                padding: 2px 3px;
                text-aligh: center
            }
            th {
                font-weight: bold;
            }
        </style>

    </head>
    <body>
        <h1>Philips TV</h1>
        <h2>${message}</h2>

        <button value="Refresh Page" onClick="showTable()">Refresh</button>
        <br>
        <br>

        <div id = "idTableDiv">
        </div>

    </div>
    <br>
    <br>
    <div class="col-md-3">
        <select id="selTV" name="selTV" class="input-sm" required="" >Select TV</select>
    </div>
    <br>
    <br>

    <!--
    <form id= "idForm" action="<c:url value="/requestIpUpgrade" />" method="POST">
        <button id="idRequestUpUpgrade" name="selectedTv" value="">Request IP-Upgrade</button>
    </form>
    -->
    <button id="idRequestUpUpgrade" name="selectedTv" value="">Request IP-Upgrade</button>


</body>
<script type="text/javascript">
    var sDateFormat = "<s:text name='global.dateformat.long'/>";
    var tableData;

    $(document).ready(function () {
        console.log("document.ready()");

        showTable();


        /*
        <c:forEach  items="${tvList}" var ="tv">
            var opt = document.createElement('option');
            opt.innerHTML = "${tv.tvUniqueID}";
            opt.value = "${tv.tvUniqueID}";
            selTV.appendChild(opt);
        </c:forEach>
        */

        /*
         document.getElementById("selTV").addEventListener("change", function () {
         var el = document.getElementById('selTV');
         var selectedTv = el.options[el.selectedIndex].value;
         
         var myInput = document.getElementById("idRequestUpUpgrade");
         myInput.value= selectedTv;
         
         });
         */

        $('#idRequestUpUpgrade').on('click', function () {
            var el = document.getElementById('selTV');
            var data = {};
            data["tvUniqueId"] = el.options[el.selectedIndex].value;
            data["function"] = "IPCloneService";
            data["CmdType"] = "Reqeust";
            $.ajax({
                type: "POST",
                url: "/requestIpUpgrade",
                data: JSON.stringify(data),
                contentType: "application/json",

                success: function (result) {
                    console.log("Form transfered");
                    // Do something with the response.
                    // Might want to check for errors here.
                }, error: function (error) {
                    console.log("transfer error");
                    // Here you can handle exceptions thrown by the server or your controller.
                }
            });
        });

    });




    function showTable() {

        $.ajax({
            type: "POST",
            url: "/getTvList",
            dataType: 'json',
            success: function (data) {
                drawTable("idTableDiv", data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error", textStatus, errorThrown);
            }
        });


    }
    ;

    function drawTable(container, data) {

        selTV.innerHTML="";
        /*
        <c:forEach  items="${tvList}" var ="tv">
            var opt = document.createElement('option');
            opt.innerHTML = "${tv.tvUniqueID}";
            opt.value = "${tv.tvUniqueID}";
            selTV.appendChild(opt);
        </c:forEach>
        */
        // EXTRACT VALUE FOR HTML HEADER. 
        var col = [];
        var opt;
        for (var i = 0; i < data.length; i++) {
            opt = document.createElement('option');
            opt.innerHTML = data[i].tvUniqueID;
            opt.value = data[i].tvUniqueID;
            selTV.appendChild(opt);
        
            for (var key in data[i]) {
                if (col.indexOf(key) === -1) {
                    col.push(key);
                }
            }
        }

        // CREATE DYNAMIC TABLE.
        var table = document.createElement("table");

        // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

        var tr = table.insertRow(-1);                   // TABLE ROW.

        for (var i = 0; i < col.length; i++) {
            var th = document.createElement("th");      // TABLE HEADER.
            th.innerHTML = col[i];
            tr.appendChild(th);
        }

        // ADD JSON DATA TO THE TABLE AS ROWS.
        for (var i = 0; i < data.length; i++) {

            tr = table.insertRow(-1);

            for (var j = 0; j < col.length; j++) {
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML = data[i][col[j]];
            }
        }

        // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
        document.getElementById(container).innerHTML = "";
        document.getElementById(container).appendChild(table);
    }
    ;
</script>

</html>
