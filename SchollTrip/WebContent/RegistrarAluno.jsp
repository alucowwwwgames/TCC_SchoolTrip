<%@page import="java.sql.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% 
   String Nome_alu = request.getParameter("iNome");
   String RM = request.getParameter("iRM");
   String Turma = request.getParameter("iTurma");
   int r;
   try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=passeio", "sa", "102938");
	
	PreparedStatement ps = con.prepareStatement("insert into Aluno(Nome_alu,RM,Turma) values (?,?,?)");
	ps.setString(1, Nome_alu);
	ps.setString(2, RM);
	ps.setString(3, Turma);
	
	r = ps.executeUpdate();
	if(r >= 1) {
		System.out.println("<h1>Message sent successfully</h1>");
	}else{
		System.out.println("<h1>Failed to send</h1>");
	}
   }catch(Exception e){
	   System.out.println(e.getMessage());
   }
  %>
</body>
</html>