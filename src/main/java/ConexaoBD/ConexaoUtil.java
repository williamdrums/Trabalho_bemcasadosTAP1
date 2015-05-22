package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoUtil {

	public static Connection getConnection() {
           Connection con = null;
		
           try {
        	try {
			Class.forName("org.postgresql.Driver");//forca o carregamento do driver
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bemcasados_tap1", "postgres", "postgres");
			
			
			System.out.println("Conectado com sucesso!!!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
           
           
           
           
           
           /*try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/bemcasados_tap1";
			String usuario = "postgres";
			String senha = "postgres";
			try {
				Connection connection = DriverManager.getConnection(url,
						usuario, senha);
				System.out.println("Conectado com sucesso!!!");
				return connection;
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoUtil.class.getName()).log(Level.SEVERE,
						null, ex);
			}

			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}*/
		

	}
}
