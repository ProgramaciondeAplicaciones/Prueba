<%-- 
    Document   : Registrado
    Created on : 10-sep-2013, 21:21:59
    Author     : Nicole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido!</h1>
        <%
            String usuarioIn="",rolIn="",nombreIn="",jefeIn="",contraseniaIn="";
            if(request.getParameter("usuario")!=null){
                
                usuarioIn=request.getParameter("usuario");
            }
            if(request.getParameter("rol")!=null){
                
                rolIn=request.getParameter("rol");
            }
            if(request.getParameter("nombre")!=null){
                
                nombreIn=request.getParameter("nombre");
            }
            if(request.getParameter("jefe")!=null){
                
                jefeIn=request.getParameter("jefe");
            }
            if(request.getParameter("contrasenia")!=null){
                
                contraseniaIn=request.getParameter("contrasenia");
            }
            %>
           
            
            <jsp:setProperty name="sesionActual" property="usuario" value="<%=usuarioIn%>"/>
            <jsp:setProperty name="sesionActual" property="nombre" value="<%=nombreIn%>"/>
            <jsp:setProperty name="sesionActual" property="rol" value="<%=rolIn%>"/>
            <jsp:setProperty name="sesionActual" property="jefe" value="<%=jefeIn%>"/>
            <jsp:setProperty name="sesionActual" property="contrasenia" value="<%=contraseniaIn%>"/>
            
            <table>
                <tr><td>Usuario</td><td><jsp:getProperty name="sesionActual" property="usuario"/></tr> 
                <tr><td>Rol</td><td><jsp:getProperty name="sesionActual" property="rol"/></tr> 
                <tr><td>Nombre</td><td><jsp:getProperty name="sesionActual" property="nombre"/></tr> 
                <tr><td>Jefe</td><td><jsp:getProperty name="sesionActual" property="jefe"/></tr> 
                <tr><td>Contrasenia</td><td><jsp:getProperty name="sesionActual" property="contrasenia"/></tr> 
            </table>
            
            
            
          
    </body>
</html>
