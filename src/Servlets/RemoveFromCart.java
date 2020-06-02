package Servlets;

import Database.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveFromCart")
public class RemoveFromCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int productID= Integer.parseInt(request.getParameter("productID"));
        ProductDAO dao= new ProductDAO();
        if (dao.removeFromCart(productID) > 0) {
            session.setAttribute("cartSize", dao.findCartSize());
            response.sendRedirect(request.getContextPath() + "/ViewCart.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
