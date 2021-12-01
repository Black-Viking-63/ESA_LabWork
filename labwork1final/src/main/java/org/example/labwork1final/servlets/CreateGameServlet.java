package org.example.labwork1final.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.labwork1final.ejb.AppBean;
import org.example.labwork1final.model.Editor;
import org.example.labwork1final.model.Game;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CreateGameServlet", value = "/CreateGameServlet", urlPatterns = "/create-game")
public class CreateGameServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> editorIds = appBean.getAllEditors().stream().map(Editor::getId).collect(Collectors.toList());
        request.setAttribute("editorIds", editorIds);
        request.getRequestDispatcher("view/CreateGame.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameGame = request.getParameter("nameGame");
        String genre = request.getParameter("genre");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Long editorId = Long.parseLong(request.getParameter("editorId"));
        appBean.createGame(new Game(nameGame, genre, price), editorId);
        response.sendRedirect(request.getContextPath() + "/games");
    }
}
