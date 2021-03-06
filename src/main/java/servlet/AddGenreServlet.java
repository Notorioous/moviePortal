package servlet;

import manager.GenreManager;
import model.Genre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addGenre")
public class AddGenreServlet extends HttpServlet {

    private GenreManager genreManager = new GenreManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        Genre genre = new Genre();
        genre.setName(name);
        genreManager.addGenre(genre);

        req.setAttribute("allGenres",genreManager.getAllGenres());
        req.setAttribute("message","Category successfully added!");
        req.getRequestDispatcher("/WEB-INF/admin/adminPanel.jsp").forward(req,resp);


    }
}
