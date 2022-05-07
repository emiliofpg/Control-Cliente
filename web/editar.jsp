<%-- 
    Document   : add
    Created on : 6 may. 2022, 8:45:40 p. m.
    Author     : emili
--%>

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
            <form action="Controlador" method="POST">
                <div class="card border-light mb-3" style="max-width: 15rem;">
                    <div class="card-header">ACTUALIZAR CLIENTE</div>
                    <div class="card-body">
                            <div class="form-g">
                            <label>ID</label>
                            <input type="text" value="${cliente.id}" name="txtid" readonly="" class="from-control">
                        </div>
                        <div class="form-g">
                            <label>NOMBRE</label>
                            <input type="text" value="${cliente.nombre}" name="txtnombre" class="from-control">
                        </div>
                        <div class="form-g">
                            <label>APELLIDO</label>
                            <input type="text" value="${cliente.apellido}" name="txtapellido" class="from-control">
                        </div>
                        <div class="form-g">
                            <label>TELEFONO</label>
                            <input type="text" value="${cliente.telefono}" name="txttelefono" class="from-control">
                        </div>
                        <div class="form-g">
                            <label>CORREO</label>
                            <input type="text" value="${cliente.correo}" name="txtcorreo" class="from-control">
                        </div>
                        <div class="form-g">
                            <label>STATUS</label>
                            <input type="text" value="${cliente.status}" name="txtstatus" class="from-control">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="actualizar" name="agregar" class="btn btn-outline-success">
                        <a class="btn btn-outline-primary" href="Controlador?accion=listar">Regresar</a>
                    </div>
                </div>
            </form>

        </div>
    </body>
</html>
