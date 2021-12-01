package org.example.labwork1final.servlets;

import org.example.labwork1final.ejb.AppBean;
import org.example.labwork1final.model.Game;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowGamesServlet", value = "/ShowGamesServlet", urlPatterns = "/games")
public class ShowGamesServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Game> games = appBean.getAllGames();
        request.setAttribute("games", games);
        request.getRequestDispatcher("view/ShowGames.jsp").forward(request, response);
    }

}
