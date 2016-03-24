package it.polito.tdp.lab3.db;

import java.sql.*;
import java.util.*;

import it.polito.tdp.lab3.model.*;

public class CorsoDAO {

	private String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";	
	
	public List<Corso> popolaTendina(){
		List<Corso>temp=new ArrayList<Corso>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql= "SELECT codins,crediti,nome,pd FROM corso";
			
			ResultSet res=st.executeQuery(sql);
			
			while(res.next()){				
				temp.add(new Corso(res.getString("codins"),res.getInt("crediti"),res.getString("nome"),res.getString("pd")));
			}
			res.close();
			conn.close();
			return temp;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}
	
	public List<Studente>iscrittiAcorso(Corso c){
		List<Studente>temp=new ArrayList<Studente>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql= String.format("SELECT S.matricola,S.cognome,S.nome,S.CDS FROM studente S,corso C,iscrizione I WHERE I.matricola=S.matricola AND C.codins=I.codins AND I.codins='%s'", c.getCodCorso());
			
			ResultSet res=st.executeQuery(sql);
			
			while(res.next()){				
				temp.add(new Studente(res.getString("matricola"),res.getString("nome"),res.getString("cognome"),res.getString("CDS")));
			}
			res.close();
			conn.close();
			return temp;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}
	
	
	
	 
	 
	 
}
