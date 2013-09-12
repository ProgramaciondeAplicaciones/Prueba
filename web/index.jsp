<%-- 
    Document   : index
    Created on : 10-sep-2013, 16:37:09
    Author     : Nicole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="http://3.bp.blogspot.com/_IL61t8K_e4E/TPA_6h9IzuI/AAAAAAAAAC4/UDRE1FTPR2A/s1600/6469_pacman_cutters_on_black1.jpg" style="background-attachment: fixed" >
        
	<p style="background-color: darksalmon; font-size:45px; font-family:Impact; color: black; float: right">PROG <br /> APLICPLAY <br />MARKET</p>
     
        <h5 style="position: absolute;top:-35px;left:310px;font-size:50px; font-family:HappyEaster; color: palegreen" >Iniciar sesion</h5>
        
        <form action="Registrado.jsp" method="post">
            <table>
                <tr><td><p style="font-size:20px; font-family:Impact; color: lightseagreen">USUARIO</p></td><td><input type="text" name="usuario"/></tr> 
                <tr><td><p style="font-size:20px; font-family:Impact; color: deepskyblue">CONTRASEÑA</p></td><td><input type="password" name="contrasenia"/></tr> 
            </table>
            <input type="submit" value="Ingresar" />   
       </form>
        <form action="ConsultaPerfil.jsp" method="post">
        <input type="submit" value="Consultar perfil" name="b_consultaPerfil" />
        <form/>
    </body>
</html>
