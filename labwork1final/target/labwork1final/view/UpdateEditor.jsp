<%@ page import="org.example.labwork1final.model.Editor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update editor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% Editor editor = (Editor) request.getAttribute("editor"); %>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/update-editor">
        <h1>Update editor</h1>
        <input type="hidden" name="editorId" value="<%= editor.getId() %>">
        <div class="form-group">
            <label for="name">First name: </label>
            <input class="form-control" id="name" name="nameEditor" type="text" value="<%= editor.getNameEditor() %>"
                   required/>
        </div>
        <br>
        <input type="submit" value="Update" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
