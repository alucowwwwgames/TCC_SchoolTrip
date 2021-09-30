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
	
	public static void Professor(String Nome_prof, String  RM_prof,String Email_prof,String Senha_prof) {
		 try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=passeio", "sa", "102938");
				
				PreparedStatement ps = con.prepareStatement("insert into Professor(Nome_prof, RM_prof, Email_prof, Senha_prof) values (?,?,?,?)");
				ps.setString(1, Nome_prof);
				ps.setString(2, RM_prof);
				ps.setString(3, Email_prof);
				ps.setString(4, Senha_prof);
				ps.executeUpdate();
			   }catch(Exception e){
				   System.out.println(e.getMessage());
			   }   
	}
	

	public static boolean professorExistente(String Nome_prof, String RM_prof) {
		boolean existPro = false;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=passeio", "sa", "102938");
			PreparedStatement ps = con.prepareStatement("select Nome_prof,RM_Prof from Professor where RM_Prof = '"+RM_prof+"'");
			/* Caso Rm não seja unico
			PreparedStatement ps = con.prepareStatement("select Nome_prof,RM_Prof from Professor where RM_Prof = "+RM+" and RM_Prof = '"+Nome_prof+"'");
			*/
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				int rm = res.getInt(2);
				if(rm > 0) {
					existPro = true;
				}
			}
			  System.out.println(existPro);
		   }catch(Exception e){
			   System.out.println(e.getMessage());
		   }
		return existPro;
		
	}
	
	
	public static void Aluno(String RM,String Nome_alu,String Email_alu, String  Senha_alu,String Turma) {
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=passeio", "sa", "102938");
			
			PreparedStatement ps = con.prepareStatement("insert into Aluno(RM,Nome_alu,Email_alu,Senha_alu,Turma) values (?,?,?,?,?)");
			ps.setString(1, RM);
			ps.setString(2, Nome_alu);
			ps.setString(3, Email_alu);
			ps.setString(4, Senha_alu);
			ps.setString(5, Turma);
			ps.executeUpdate();
		   }catch(Exception e){
			   System.out.println(e.getMessage());
		   }
		
	}
	
    public static boolean AlunoExistente(String Nome_alu,String  RM, String Turma) {
		boolean existAl = false;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=passeio", "sa", "102938");
			PreparedStatement ps = con.prepareStatement("select Nome_alu,RM from Aluno where RM = '"+RM+"'");
			/* Caso Rm não seja unico
			PreparedStatement ps = con.prepareStatement("select Nome_alu,RM from Aluno where RM = "+RM+" and Nome_alu = '"+Nome_alu+"'");
			*/
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				int rm = res.getInt(2);
				if(rm > 0) {
					existAl = true;
				}
			
			}
			  System.out.println(existAl);
		   }catch(Exception e){
			   System.out.println(e.getMessage());
		   }
		return existAl;
		
	}
	
	
}
