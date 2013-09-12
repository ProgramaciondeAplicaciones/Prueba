<%-- 
    Document   : menuInicioS
    Created on : 10-sep-2013, 19:39:14
    Author     : Nicole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Dejando esto aca para saber si el svn lo está subiendo -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="validar.jsp" method="POST">
              <table border="1" align="center">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th><input type="text" name="f_nombre" value="" /></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="f_clave" value=""  /></td>
                </tr>
                <tr>
                    
            <input type="submit" value="Iniciar sesión"/>
                </tr>
            </tbody>
        </table>

        </form>
    </body>
</html>
