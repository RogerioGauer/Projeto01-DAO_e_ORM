<%-- 
    Document : atualizar
    Created on : 13 de set. de 2021, 15:36:53
    Author : Rogerio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Curso" %>
<%@page import="model.CursoDAO" %>
<%
String cod = request.getParameter("cod");    
CursoDAO dao = new CursoDAO();
Curso obj = dao.buscar("codigo="+cod);
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="curso" value="<%=obj%>" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto 01 - DAO e ORM: Atualizar</title>
    </head>    
    <body>
        <h1>Formulário de Atualização de um Curso:</h1>
        
        <form action="exec" method="post">                 
            
            <input type="number" name="cod" readonly="true" value="${curso.codigo}">
            <br><br>
            
            Nome:<br>
            <input type="text" name="nom" value="${curso.nome}">
            <br><br>
            
            Descrição:<br>
            <textarea rows="5" cols="20" name="des">${curso.descricao}</textarea>
            <br><br>
            
            Valor:<br>          
            <input type="number" name="val" value="${curso.valor}">   
            <br><br>
            
            <input type="hidden" name="tip" value="update">
               
            <button>Atualizar</button>
            
        </form>
    </body>
</html>

