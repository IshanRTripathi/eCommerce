package Servlets;

import Database.ProductDAO;
import Models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO= new ProductDAO();
        List<Product> products= productDAO.getItemsFromCart();
        HttpSession session = request.getSession();
        session.setAttribute("cartItems", products);
        response.sendRedirect(request.getContextPath() + "/ViewCart.jsp");
    }
}
