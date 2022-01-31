package com.BookAirlines;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/UserLogin")
public class LoginOfUser extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
String email=request.getParameter("email");
String password=request.getParameter("password");
try {
ConnectionUtil dao=new ConnectionUtil();
HashMap<String,String> user=dao.checkUser(email,password);
HttpSession session=request.getSession();
if(user!=null) {
session.setAttribute("user", user);
response.sendRedirect("HomePage.jsp");
}
else {
session.setAttribute("message", "Invalid Details");
response.sendRedirect("UserPage.jsp");
}
} catch (ClassNotFoundException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
