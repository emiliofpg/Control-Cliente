<%-- 
    Document   : index
    Created on : 5 may. 2022, 9:00:59 p. m.
    Author     : emili
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4">
            <h3>Control de Clientes 2022</h3>
            <div>
                <a class="btn btn-outline-primary" href="Controlador?accion=listar">Listar</a>
                <a class="btn btn-outline-primary" href="Controlador?accion=nuevo">Agregar Nuevo</a>
            </div>

            <hr> 
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>TELEFONO</th>
                    <th>CORREO</th>
                    <th>STATUS</th>
                    <th>ACCIONES</th>
                </tr>
                <c:forEach var="cliente" items="${Clientes}">
                    <tr>


                        <td>${cliente.id}</td>
                        <td>${cliente.nombre}</td>
                        <td>${cliente.apellido}</td>
                        <td>${cliente.telefono}</td>
                        <td>${cliente.correo}</td>
                        <td>${cliente.status}</td>
                        <td>
                            <a href="Controlador?accion=editar&id=${cliente.id}" class="btn btn-outline-warning">Editar</a>
                            <a href="Controlador?accion=eliminar&id=${cliente.id}" class="btn btn-outline-danger">Eliminar</a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>


    </body>
</html>
