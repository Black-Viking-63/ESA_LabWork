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
@WebServlet(name = "UpdateEditorServlet", value = "/UpdateEditorServlet", urlPatterns = "/update-editor")
public class UpdateEditorServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long editorId = Long.parseLong(request.getParameter("editorId"));
        Editor editor = appBean.getEditorById(editorId);
        request.setAttribute("editor", editor);
        request.getRequestDispatcher("view/UpdateEditor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long editorId = Long.parseLong(request.getParameter("editorId"));
        String name = request.getParameter("nameEditor");
        appBean.updateEditor(editorId, new Editor(name));
        response.sendRedirect(request.getContextPath() + "/editors");
    }
}
