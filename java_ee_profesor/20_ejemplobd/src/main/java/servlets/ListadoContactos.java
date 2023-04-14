package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListadoContactos
 */
@WebServlet("/ListadoContactos")
public class ListadoContactos extends HttpServlet {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String cadenaCon="jdbc:mysql://localhost:3307/ejemplobd";
	private static final String user="root";
	private static final String pwd="root";
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName(driver);
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			return;
		}
		
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){			
			String sql="select * from contactos";
			Statement st=con.createStatement();			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("nombre")+"-"+rs.getInt("edad"));
			}
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
