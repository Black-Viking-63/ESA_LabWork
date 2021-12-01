<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Long> editorIds = (List<Long>) request.getAttribute("editorIds"); %>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/create-game">
        <h1>Create game</h1>
        <div class="form-group">
            <label for="nameGame">Name Game: </label>
            <input class="form-control" id="nameGame" name="nameGame" type="text" required/>
        </div>
        <div class="form-group">
            <label for="genre">Genre: </label>
            <input class="form-control" id="genre" name="genre" type="text" required/>
        </div>
        <div class="form-group">
            <label for="price">Price: </label>
            <input class="form-control" id="price" name="price" type="number" min="1" max="1000"
                   required/>
        </div>
        <div class="form-group">
            <label for="editorId">Editor id: </label>
            <select class="form-control" id="editorId" name="editorId" required>
                <% for (Long editorId : editorIds) {%>
                <option value="<%= editorId %>"><%= editorId %>
                </option>
                <%}%>
            </select>
        </div>
        <br>
        <input type="submit" value="Create" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
