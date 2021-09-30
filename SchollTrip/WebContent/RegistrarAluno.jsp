<%@page import="java.sql.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% 
   String RM = request.getParameter("iRM");
   String Nome_alu = request.getParameter("iNome");
   String Email_alu = request.getParameter("iEmailA");
   String Senha_alu = request.getParameter("iSenhaA");
   String Turma = request.getParameter("iTurma");
   
   boolean exist = UserDao.AlunoExistente(Nome_alu,RM,Turma);         
   if(!exist){
   UserDao.Aluno(RM,Nome_alu,Email_alu,Senha_alu,Turma);
   System.out.println("Aluno cadastrado com sucesso");
   %>
  <h1>no</h1>   
   <%
   }
   else{
	   System.out.println("Aluno já existente");  
 %>
  
  <h1>yes</h1>
 <%
   
   }
  %>