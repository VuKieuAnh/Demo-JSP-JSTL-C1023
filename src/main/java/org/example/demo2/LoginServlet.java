package org.example.demo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("ten");
        int tuoi = Integer.parseInt(req.getParameter("tuoi"));
        if (name.equals("KieuAnh")){
            tuoi=18;
        }
        System.out.println("ten " + name+ " tuoi "+ tuoi);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("ten");
        int tuoi = Integer.parseInt(req.getParameter("tuoi"));
        if (name.equals("KieuAnh")){
            tuoi=18;
        }
        System.out.println("ten " + name+ " tuoi "+ tuoi);
        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + name + "</h1>");
        out.println("<h1>" + tuoi + "</h1>");
        out.println("</body></html>");
    }
}
