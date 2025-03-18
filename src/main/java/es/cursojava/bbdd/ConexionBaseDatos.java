package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class ConexionBaseDatos {
    public static void main(String[] args) {
        
        conectaOracle2();
    }


    private static void conectaOracle() {
		String url_oracle = "jdbc:oracle:thin:getafesql/password@localhost:1522:XE";
		String url_oracle2 = "jdbc:oracle:thin:@localhost:1522:XE";
		String username = "getafesql";
		String password = "password";

		
		try (Connection connection = DriverManager.getConnection(url_oracle2, username, password);) {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			if (connection!=null) {
				System.out.println("Conexion establecida");
			}
			
		} catch (SQLException e) {
			System.err.println("Ha habido un error " + e.getMessage());
//			e.printStackTrace();
		} 
        // catch (ClassNotFoundException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }

	}
	
	
	private static void conectaOracle2() {
		String url_oracle = "jdbc:oracle:thin:getafesql/password@localhost:1522:XE";
		String url_oracle2 = "jdbc:oracle:thin:@localhost:1522:XE";
		String username = "getafesql";
		String password = "password";
		try {
			OracleDataSource ods = new OracleDataSource();
			try (Connection connection =  ods.getConnection();   )  {
				ods.setURL(url_oracle);
				if (connection!=null) {
					System.out.println("Conexion establecida");
				}
				System.out.println(7/0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
