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
import java.util.List;

@WebServlet(name = "ViewProducts")
public class ViewProducts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        /*ProductDAO dao = new ProductDAO();

        List<Product> products = dao.getAllProducts();
        System.out.println("\n\n\nProduct details:"+products);
        HttpSession session = request.getSession();

        session.setAttribute("productList", products);

        session.setAttribute("cartSize",dao.findCartSize());*/

        response.sendRedirect(request.getContextPath()+"/viewProducts.jsp");
    }
}