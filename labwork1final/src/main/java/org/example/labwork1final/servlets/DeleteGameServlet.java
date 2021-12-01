package org.example.labwork1final.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.labwork1final.ejb.AppBean;

import java.io.IOException;

@WebServlet(name = "DeleteGameServlet", value = "/DeleteGameServlet", urlPatterns = "/delete-game")
public class DeleteGameServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long gameId = Long.parseLong(request.getParameter("gameId"));
        appBean.deleteGame(gameId);
        response.sendRedirect(request.getContextPath() + "/games");
    }
}
