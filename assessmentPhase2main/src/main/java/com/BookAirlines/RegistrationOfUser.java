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
@WebServlet("/UserRegistration")
public class RegistrationOfUser extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
String email=request.getParameter("email");
String password=request.getParameter("password");
String name=request.getParameter("name");
String phno=request.getParameter("phno");
String adno=request.getParameter("adno");
HashMap<String,String> user=new HashMap<>();
user.put("email", email);
user.put("password", password);
user.put("name", name);
user.put("phno", phno);
user.put("adno", adno);
try {
ConnectionUtil dao=new ConnectionUtil();
boolean result=dao.insertUser(user);
HttpSession session=request.getSession();
if(result) {
session.setAttribute("message", "User Added Successfully");
}
else {
session.setAttribute("message","Invalid Details");
}
} catch (ClassNotFoundException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
response.sendRedirect("UserPage.jsp");
}
}

