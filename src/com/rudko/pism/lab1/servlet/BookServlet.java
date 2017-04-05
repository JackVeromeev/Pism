package com.rudko.pism.lab1.servlet;

import com.rudko.pism.lab1.dao.BookList;
import com.rudko.pism.lab1.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by jack on 18/03/17.
 */
@WebServlet(name = "BookServlet", urlPatterns = "/lab2")
public class BookServlet extends HttpServlet {

    private static String ERR_BEG = "<font color = \"red\">";
    private static String ERR_END = "</font>";

    private static String ADD_ERROR = ERR_BEG
            + "An error occurred while addind: ";
    private static String ADD_ERROR_NAME = ADD_ERROR
            + "empty name" + ERR_END;
    private static String ADD_ERROR_AUTHOR = ADD_ERROR
            + "empty author" + ERR_END;
    private static String ADD_ERROR_YEAR = ADD_ERROR
            + "wrong (not integer or null) year" + ERR_END;
    private static String ADD_SUCCESS = "Book added successfully";

    private static String DELETE_ERROR = ERR_BEG
            + "An error occurred while deleting" + ERR_END;
    private static String DELETE_SUCCESS = "Book deleted successfully";

    private static String ACTION_ERROR = ERR_BEG+ "Wrong action param"
            + ERR_END;



    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String statusMessage = ACTION_ERROR;
        if ("add".equals(action)) {
            statusMessage = addBook(request);
        } else if ("del".equals(action)) {
            statusMessage = deleteBook(request);
        }
        response.sendRedirect("lab2?status=" + statusMessage);

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        new BufferedWriter(new FileWriter(
                new File("/home/jack/Documents/2.txt")
        )) . write("AYYY LMAO GET");
        String status = request.getParameter("status");
        request.setAttribute("books", BookList.getBooks());
        request.getRequestDispatcher("lab2/books.jsp" + "?status=" + status)
                .forward(request, response);
    }

    private Book getBookFromRequest(HttpServletRequest request)
            throws Exception {
        String name = request.getParameter("name");
        if (name == null || "".equals(name)) {
            throw new Exception(ADD_ERROR_NAME);
        }

        String author = request.getParameter("author");
        if (author == null || "".equals(author)) {
            throw new Exception(ADD_ERROR_AUTHOR);
        }

        int year;
        String yearString = request.getParameter("year");
        if(yearString == null || "".equals(yearString)) {
            throw new Exception(ADD_ERROR_YEAR);
        }
        else year = Integer.parseInt(yearString);

        return new Book(name, author, year);
    }

    private String addBook(HttpServletRequest request) {
        try {
            Book newBook = getBookFromRequest(request);
            BookList.add(newBook);
            return ADD_SUCCESS;
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }

    private String deleteBook(HttpServletRequest request) {
        int idToDelete = Integer.parseInt(request.getParameter("id"));

        try {
            new BufferedWriter(new FileWriter(
                    new File("/home/jack/Documents/2.txt")
            )).write("EEEE DELETE id=" + idToDelete);

            if (BookList.deleteBook(idToDelete)) {
                return DELETE_SUCCESS;
            }
            return DELETE_ERROR;
        } catch (IOException e) {
            return DELETE_ERROR + " (" + e.getMessage() + ")";
        }
    }
}