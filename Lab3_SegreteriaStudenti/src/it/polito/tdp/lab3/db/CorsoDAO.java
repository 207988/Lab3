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
	
	
	/* SELECT S.matricola,S.cognome,S.nome,S.CDS
	FROM studente S,corso C,iscrizione I
	WHERE I.matricola=S.matricola AND C.codins=I.codins AND I.codins='iscrizione'
	*/
	 
	 
	 
}
