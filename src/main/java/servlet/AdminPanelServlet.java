package servlet;

import manager.GenreManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/adminPanel")
public class AdminPanelServlet extends HttpServlet {

    private GenreManager genreManager = new GenreManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("allGenres",genreManager.getAllGenres());
        req.getRequestDispatcher("/WEB-INF/admin/adminPanel.jsp").forward(req,resp);

    }
}
