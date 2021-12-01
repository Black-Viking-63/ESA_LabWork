<%@ page import="org.example.labwork1final.model.Game" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Games</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Game> games = (List<Game>) request.getAttribute("games"); %>
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
        <caption style="caption-side: top">Games</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name Game</th>
            <th>Genre</th>
            <th>Price</th>
            <th>Editor</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Game game : games) { %>
        <tr>
            <td><%= game.getId() %>
            </td>
            <td><%= game.getNameGame() %>
            </td>
            <td><%= game.getGenre() %>
            </td>
            <td><%= game.getPrice() %>
            <td><%= game.getEditor().getId() %>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-game">
                    <input type="hidden" name="gameId" value="<%= game.getId() %>">
                    <input type="submit" class="btn btn-primary" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-game" method="post">
                    <input type="hidden" name="gameId" value="<%= game.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/create-game" method="get">
        <button class="btn btn-primary">Create Game</button>
    </form>
</div>
</body>
</html>
