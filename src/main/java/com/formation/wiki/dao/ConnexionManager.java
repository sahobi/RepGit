package com.formation.wiki.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {
	public static  String url="jdbc:mysql://localhost:3306/wiki";
	public static  String user="root";
	public static  String passeword="";
	
	public static Connection getConnexion(){
		Connection con=null;
		
		try {
			
			//pour charger le driver.
			Class.forName("com.mysql.jdbc.Driver");
			
			// pour récuperer une connexion.
			con=DriverManager.getConnection(url, user, passeword);
		} catch (ClassNotFoundException e) {
			 System.out.println("erreur lors du connection ");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erreur lors de connexion à la base de données ");
		}
		return con;
	}

}
