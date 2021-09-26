package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
  
	public static void Mensagem(String Mensagem, String Email_contato) {
		int rCont;
		   try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=passeio", "sa", "102938");
			
			PreparedStatement ps = con.prepareStatement("insert into Contato (Email_contato,Mensagem) values (?,?)");
			ps.setString(1,Email_contato);
			ps.setString(2, Mensagem);
			
			rCont = ps.executeUpdate();
			if(rCont >= 1) {
				 System.out.println("<h1>Mensagem salva com sucesso</h1>");
			}else{
				 System.out.println("<h1>falha ao salvar mensagem</h1>");
			}
		   }catch(Exception e){
			   System.out.println(e.getMessage());
		   }
	}
	
	public static void Professor(String Nome_prof, String  RM_Prof) {
		   try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=passeio", "sa", "102938");
			
			PreparedStatement ps = con.prepareStatement("insert into Professor(Nome_prof,RM_Prof) values (?,?)");
			ps.setString(1,Nome_prof);
			ps.setString(2, RM_Prof);
			
			ResultSet vn = ps.executeQuery();
			
			if(vn.next()) {
				System.out.println("Message sent successfully");
			}else{
				System.out.println("Failed to send");
			}
			
		   }catch(Exception e){
			   System.out.println(e.getMessage());
		   }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
