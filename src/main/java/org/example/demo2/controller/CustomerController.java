package org.example.demo2.controller;

import org.example.demo2.model.Customer;
import org.example.demo2.model.service.CustomerService;
import org.example.demo2.model.service.CustomerServiceJDBC;
import org.example.demo2.model.service.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {
    static ICustomerService customerService = new CustomerServiceJDBC();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        customerService.getConnection();
        String action = req.getParameter("action");
        action = action==null?"":action;
        switch (action){
            case "create":
                showFormCreate(req, resp);
                break;
            default:
                showAllCustomer(req, resp);
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showAllCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        don request tu client
//        dieu huong sang file jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("customerlist.jsp");
//        lay du lieu
        List<Customer> c = customerService.findAll();
        //        gan lai du lieu cho view
        req.setAttribute("kh", c);

        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action==null?"":action;
        switch (action){
            case "create":
                createNewCustomer(req, resp);
                break;
            case "find":
                showFindByName(req, resp);
        }
    }

    private void showFindByName(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("find By name");
        String name = req.getParameter("name");
        List<Customer> customerList = customerService.findByName(name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customerlist.jsp");
        req.setAttribute("kh", customerList);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createNewCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String dob = req.getParameter("dateOfBirth");
        String add = req.getParameter("address");
        Customer customer = new Customer(name, dob, add);
//        CustomerService c = new CustomerService();
        customerService.save(customer);
        try {
            resp.sendRedirect("/customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
