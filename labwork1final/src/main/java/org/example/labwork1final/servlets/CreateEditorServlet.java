package org.example.labwork1final.servlets;

import org.example.labwork1final.model.Editor;
import org.example.labwork1final.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreateEditorServlet", value = "/CreateEditorServlet", urlPatterns = "/create-editor")
public class CreateEditorServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/CreateEditor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameEditor");
        appBean.createEditor(new Editor(name));
        response.sendRedirect(request.getContextPath() + "/editors");
    }
}
