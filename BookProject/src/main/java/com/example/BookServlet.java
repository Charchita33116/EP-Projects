package com.example;
import com.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        List<Book> bookList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "Chand1807#");
            ps = con.prepareStatement("SELECT * FROM book WHERE bname LIKE ?");
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBid(rs.getInt("bid")); // Use column names for better readability
                book.setBname(rs.getString("bname"));
                book.setBprice(rs.getDouble("bprice"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e); // Forward to error handling in your servlet container
        } finally {
            // Ensure resources are closed properly
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        request.setAttribute("bookList", bookList);
        RequestDispatcher rd = request.getRequestDispatcher("bookSearch.jsp");
        rd.forward(request, response);
    }
}

