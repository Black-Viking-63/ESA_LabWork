package org.example.labwork1final.servlets;

import org.example.labwork1final.ejb.AppBean;
import org.example.labwork1final.model.Editor;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowEditorsServlet", value = "/ShowEditorsServlet", urlPatterns = "/editors")
public class ShowEditorsServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Editor> editors = appBean.getAllEditors();
        request.setAttribute("editors", editors);
        request.getRequestDispatcher("view/ShowEditors.jsp").forward(request, response);
    }

}