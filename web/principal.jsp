<%-- 
    Document   : principal
    Created on : 8/04/2014, 11:58:55 PM
    Author     : JL
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>iCompras</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="../../assets/ico/favicon.ico">
        <!-- Bootstrap core CSS -->
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <script language="javascript" type="text/javascript">
            function get_XmlHttp()
            {
                // Crea la variable que contendrá la instancia del objeto  XMLHttpRequest (inicialmente con un valor nulo)
                var xmlHttp = null;

                if (window.XMLHttpRequest)
                {       // para Forefox, IE7+, Opera, Safari, ...
                    xmlHttp = new XMLHttpRequest();
                }
                else if (window.ActiveXObject)
                {  // para Internet Explorer 5 or 6
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }

                return xmlHttp;
            }
            
            function perfil(){
                var request = get_XmlHttp();
                var pItem = "submit=Consulta";
                request.open("POST", "./usuarios", true);
                request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                request.send(pItem);
                request.onreadystatechange = function()
                {

                    if (request.readyState == 4)
                    {
                        var ex_ajsn = request.responseText;
                        document.getElementById("respuesta").innerHTML = ex_ajsn;

                    }
                }
            }

            function catalogo()
            {
                var request = get_XmlHttp();
                var pItem = "submit=Consulta";
                request.open("POST", "./productos", true);
                request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                request.send(pItem);
                request.onreadystatechange = function()
                {

                    if (request.readyState == 4)
                    {
                        var ex_ajsn = request.responseText;
                        document.getElementById("inicioTab").innerHTML = ex_ajsn;

                    }
                }

            }

        </script>

    </head>

    <body onload="catalogo()">
        <%@include file="layouts/navbar.html" %>
        <div class="container-fluid">
            <div class="row">
                <div class="container main">
                    <h1 class="text-right page-header">Hola Usuario</h1>
                    <div class="row">
                        <ul id="myTab" class="nav nav-tabs">
                            <li class="active"><a href="#inicioTab" onclick="catalogo()" data-toggle="tab">Inicio</a></li>
                            <li><a href="#registroProdTab" data-toggle="tab">Registrar Productos</a></li>
                            <li><a href="#ventasTab" data-toggle="tab">Ventas</a></li>
                            <li><a href="#perfilTab" onclick="perfil()" data-toggle="tab">Perfil</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade  in active" id="inicioTab">
                            </div>
                            <div class="tab-pane fade" id="registroProdTab">
                                <%@include file="layouts/vendedor/registroProducto.html" %>
                            </div>
                            <div class="tab-pane fade" id="ventasTab">
                                <%@include file="layouts/vendedor/historial.html" %>
                            </div>
                            <div class="tab-pane fade" id="perfilTab">
                                <%@include file="layouts/vendedor/perfil.html" %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
        <script src="dist/js/docs.min.js"></script>
    </body>
</html>