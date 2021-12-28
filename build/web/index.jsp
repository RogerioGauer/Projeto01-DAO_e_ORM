<%--
    Document : index
    Created on : 10 de set. de 2021, 16:04:36
    Author : Rogerio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean class="model.CursoDAO" id="lista"/> 

<%--
 //Outro método para listar os itens do banco de dados:

 <%@page import="java.util.List"%>
 <%@page import="model.Curso"%>
 <%@page import="model.CursoDAO"%>

    CursoDAO dao = new CursoDAO();
    List<Curso> lst = dao.listar();

    <c:set var="lista" value="<%= lst %>" />
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto 01 - DAO e ORM</title>
    </head>
    <body>
        <h1>DAO = Data Access Object = Objeto de Acesso a Dados</h1>
        <h1>ORM = Object Relational Mapper = Mapeador Relacional de Objeto</h1>
        
        <a href="cadastrar.jsp">Cadastrar um Novo Curso</a>
        <br><br>

        <h2>Estes são os Cursos Disponíveis:</h2>
        
        <h4>
        <c:forEach items="${lista.cursos}" var="objcur">
            <strong>${objcur.nome}</strong> ==> ${objcur.valor} 
            <br>
            <a href="atualizar.jsp?cod=${objcur.codigo}">[ A ]</a> :: 
            <a href="exec?tip=delete&cod=${objcur.codigo}">[ X ]</a> 
            <br><br>
        </c:forEach>
        </h4>
           
    </body>
</html>
