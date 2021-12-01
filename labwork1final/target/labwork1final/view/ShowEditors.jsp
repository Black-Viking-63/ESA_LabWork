<%@ page import="java.util.List" %>
<%@ page import="org.example.labwork1final.model.Editor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editors</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Editor> editors = (List<Editor>) request.getAttribute("editors"); %>
<div class="container">
    <ul class="nav justify-content-center">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/editors">Show editors</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/games">Show games</a>
        </li>
    </ul>
    <table class="table table-striped table-dark table-hover">
        <caption style="caption-side: top">Editors</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Editor editor : editors) { %>
        <tr>
            <td><%= editor.getId() %>
            </td>
            <td><%= editor.getNameEditor() %>
            <td>
                <form action="${pageContext.request.contextPath}/update-editor">
                    <input type="hidden" name="editorId" value="<%= editor.getId() %>">
                    <input type="submit" class="btn btn-primary" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-editor" method="post">
                    <input type="hidden" name="editorId" value="<%= editor.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/create-editor" method="get">
        <button class="btn btn-primary">Create editor</button>
    </form>
</div>
</body>
</html>
