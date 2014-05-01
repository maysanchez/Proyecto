<%-- 
    Document   : index
    Created on : 8/04/2014, 08:07:15 PM
    Author     : JL
--%>

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
    </head>

    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><i class="glyphicon glyphicon-home"></i></a>
                </div>
                <div class="navbar-collapse collapse">
                    <%
                        Date now = new Date();
                        String horas = String.valueOf(now.getHours());
                        String mins = String.valueOf(now.getMinutes());
                        String seconds = String.valueOf(now.getSeconds());
                    %>
                    <p class="lead navbar-text col-md-offset-12"><strong><%= horas%>:<%= mins%>:<%= seconds%></strong></p>
                    <ul class="nav navbar-nav navbar-right">
                        <input id="hide" type="hidden" value="true"/>
                        <li><button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-user"></i> Iniciar Sesi&oacute;n</button></li>
                        <li><button type="button" class="btn btn-default navbar-btn"><i class="glyphicon glyphicon-check"></i> Registrate</button></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="container main">
                    <div class="row placeholders">
                        <div class="jumbotron col-md-8 col-md-offset-2">
                            <h1 class="page-header text-center" id="titulo">Bienvenido a iCompras</h1>
                            <p class="lead">Puedes realizar compras de cualquier artículo entra, vizualiza las marcas registradas y comienza a obtener miles de descuentos</p>
                            <p><a href="principal.jsp" class="btn btn-primary btn-lg" role="button">Ver Productos</a></p>
                        </div>
                    </div>
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Inicio de Sesión</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-signin" role="form">
                                        <h2 class="form-signin-heading">Ingresa los datos</h2>
                                        <input name="email" type="email" class="form-control" placeholder="Email address" required autofocus>
                                        <input name="pass" type="password" class="form-control" placeholder="Password" required>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button name="submit" class="btn btn-success" type="submit" value="Access">Entrar</button>
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                </div>
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