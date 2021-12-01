package org.example.labwork1final.servlets;

import org.example.labwork1final.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteEditorServlet", value = "/DeleteEditorServlet", urlPatterns = "/delete-editor")
public class DeleteEditorServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long editorId = Long.parseLong(request.getParameter("editorId"));
        appBean.deleteEditor(editorId);
        response.sendRedirect(request.getContextPath() + "/editors");
    }
}
