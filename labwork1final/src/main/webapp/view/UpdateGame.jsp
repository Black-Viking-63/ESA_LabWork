<%@ page import="java.util.List" %>
<%@ page import="org.example.labwork1final.model.Game" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<%
    List<Long> editorIds = (List<Long>) request.getAttribute("editorIds");
    Game game = (Game) request.getAttribute("game");
%>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/update-game">
        <h1>Update Game</h1>
        <input type="hidden" name="gameId" value="<%= game.getId() %>">
        <div class="form-group">
            <label for="nameGame">Name Game: </label>
            <input class="form-control" id="nameGame" name="nameGame" type="text" value="<%= game.getNameGame() %>"
                   required/>
        </div>
        <div class="form-group">
            <label for="genre">Genre: </label>
            <input class="form-control" id="genre" name="genre" type="text" value="<%= game.getGenre() %>"
                   required/>
        </div>
        <div class="form-group">
            <label for="price">Price: </label>
            <input class="form-control" id="price" name="price" type="number" value="<%= game.getPrice() %>"
                   required>
        </div>
        <div class="form-group">
            <label for="editorId">Editor Id: </label>
            <select class="form-control" id="editorId" name="editorId" required>
                <% for (Long editorId : editorIds) {%>
                <% if (editorId.equals(game.getEditor().getId())) {%>
                <option value="<%= editorId %>" selected><%= editorId %>
                </option>
                <%} else {%>
                <option value="<%= editorId %>"><%= editorId %>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <br>
        <input type="submit" value="Update" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
