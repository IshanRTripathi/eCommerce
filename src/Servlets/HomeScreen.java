package Servlets;

import Database.ProductDAO;
import Models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HomeScreen")
public class HomeScreen extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        out.print("Success!!");
        out.println("Welcome "+request.getParameter("username"));

        ProductDAO dao = new ProductDAO();

        List<Product> products = dao.getAllProducts();
        HttpSession session = request.getSession();

        session.setAttribute("productList", products);

        session.setAttribute("cartSize",dao.findCartSize());

        response.sendRedirect(request.getContextPath() + "/viewProducts.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
