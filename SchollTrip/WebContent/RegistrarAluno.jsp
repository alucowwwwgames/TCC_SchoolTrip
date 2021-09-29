<%@page import="java.sql.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% 
   String Nome_alu = request.getParameter("iNome");
   String RM = request.getParameter("iRM");
   String Turma = request.getParameter("iTurma");
   boolean exist = UserDao.AlunoExistente(Nome_alu,RM,Turma);
   if(!exist){
   UserDao.Aluno(Nome_alu,RM,Turma);
   System.out.println("usuario cadastrado com sucesso");
   %>
  <h1>no</h1>   
   <%
   }
   else{
	   System.out.println("usuario já existente");  
 %>
  
  <h1>yes</h1>
 <%
   
   }
  %>