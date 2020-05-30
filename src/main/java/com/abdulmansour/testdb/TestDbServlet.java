package com.abdulmansour.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // setup connection variables
        String user = "springmvcstudent";
        String pass = "springmvcstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        //get connection to database
        try {
            PrintWriter out = response.getWriter();
            out.println("Connection to database: " + jdbcUrl);

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("Successful Connection!");
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
