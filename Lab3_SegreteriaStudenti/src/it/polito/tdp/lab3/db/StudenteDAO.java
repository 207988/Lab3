package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Corso> corsiStudente(Studente s){
		List<Corso>temp=new ArrayList<Corso>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql= String.format("SELECT C.codins,C.crediti,C.nome,C.pd FROM studente S,iscrizione I, corso C WHERE C.codins=I.codins AND S.matricola=I.matricola AND S.matricola='%s'", s.getMatricola());
			
			
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
	
	public boolean studenteCorso(Studente s,Corso c){
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql= String.format("SELECT S.matricola FROM studente S,iscrizione I WHERE I.matricola=S.matricola AND S.matricola= '%s' AND I.codins='%s'", s.getMatricola(),c.getCodCorso());
			
			
			ResultSet res=st.executeQuery(sql);
			
			if(res.next()){
				return true;
			}			
			res.close();
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return false;
	}
}
