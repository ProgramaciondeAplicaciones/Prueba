<%-- 
    Document   : validar
    Created on : 10-sep-2013, 19:40:15
    Author     : Nicole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%!
            String s_nombre;
            String s_clave;
            
            
            %>
    </head>
    <body>
        <%
        s_nombre=request.getParameter("f_nombre");
        s_clave=request.getParameter("f_clave");
        if(s_nombre.equals("Nicole") && s_clave.equals("c"))
        {
            response.sendRedirect("menu.jsp");
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
            
            
            %>
    </body>
</html>
