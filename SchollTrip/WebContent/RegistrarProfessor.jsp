<%@page import="java.sql.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% 
   String RM_prof = request.getParameter("iRM_Prof");  
   String Nome_prof = request.getParameter("iNome_Prof");
   String Email_prof = request.getParameter("iEmail_Prof");
   String Senha_prof = request.getParameter("iSenha_Prof");
   
   boolean exist = UserDao.professorExistente(Nome_prof,RM_prof);
   if(!exist){
   UserDao.Professor( Nome_prof, RM_prof, Email_prof, Senha_prof);
   out.println("<h1>no</h1>");
   }
   else{
	   out.println("<h1>yes</h1>");
   }
  %>