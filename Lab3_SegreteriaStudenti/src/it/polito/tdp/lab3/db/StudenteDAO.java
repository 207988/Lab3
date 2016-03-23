package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class StudenteDAO {

	private String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
	
	public Studente cercaStudente(String matricola){
		Studente s=null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql= String.format("SELECT matricola,cognome,nome,CDS FROM studente WHERE matricola='%s'", matricola);
			//String sql="SELECT matricola,cognome,nome,CDS FROM studente WHERE matricola=\""+matricola+"\"";
			
			ResultSet res=st.executeQuery(sql);
			
			if(res.next()){
				s=new Studente(res.getString("matricola"),res.getString("nome"),res.getString("cognome"),res.getString("CDS"));
			}
			
			
			res.close();
			conn.close();
			return s;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return s;
	}
}
