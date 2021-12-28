<%-- 
    Document : cadastrar
    Created on : 13 de set. de 2021, 15:18:10
    Author : Rogerio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto 01 - DAO e ORM: Cadastrar</title>
    </head>    
    <body>
        <h1>Formulário de Cadastro de um Curso:</h1>
        
        <form action="exec" method="post">            
           
            Nome:<br>
            <input type="text" name="nom">
            <br><br>
            
            Descrição:<br>
            <textarea rows="5" cols="20" name="des"></textarea>
            <br><br>
            
            Valor:<br>          
            <input type="number" name="val">
            <br><br>     
            
            <input type="hidden" name="tip" value="insert">
            
            <button>Cadastrar</button>             
          
        </form>
    </body>
</html>
