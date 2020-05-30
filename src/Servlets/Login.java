/*
Question Link - 
*/
package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        PrintWriter out= resp.getWriter();
        out.println("Welcome!\nUsername: "+req.getParameter("username")+
                "\nPassword: "+req.getParameter("password"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        String p=request.getParameter("password");

        if(p.equals("password")){
            RequestDispatcher rd=request.getRequestDispatcher("/homeScreen");
            rd.forward(request, response);
        }
        else{
            out.print("Wrong UserName or Password !");
            RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
            rd.include(request, response);
        }
    }
}