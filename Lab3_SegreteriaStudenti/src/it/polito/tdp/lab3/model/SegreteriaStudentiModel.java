package it.polito.tdp.lab3.model;

import java.util.*;

import it.polito.tdp.lab3.db.CorsoDAO;
import it.polito.tdp.lab3.db.StudenteDAO;

public class SegreteriaStudentiModel {
	
	public List<Corso> popolaTendina(){		
		CorsoDAO cD=new CorsoDAO();
		List<Corso> temp=new ArrayList<Corso>();
		temp.add(new Corso("",-1,"---ELENCO CORSI---",""));
		temp.addAll(cD.popolaTendina());
		return temp;	
	}
	
	public Studente cercaStudente(String matricola){		
		StudenteDAO sD=new StudenteDAO();			
		return sD.cercaStudente(matricola);
	}
	
	public List<Studente>iscrittiAcorso(Corso c){
		CorsoDAO cD=new CorsoDAO();
		return cD.iscrittiAcorso(c);
	}

	public List<Corso>corsiStudente(Studente s){
		StudenteDAO sD=new StudenteDAO();
		return sD.corsiStudente(s);
	}
	
	public boolean studenteCorso(Studente s,Corso c){
		StudenteDAO sD=new StudenteDAO();
		return sD.studenteCorso(s, c);
	}
	
	public boolean iscriviStudente(Studente s,Corso c){
		CorsoDAO cD=new CorsoDAO();
		return cD.iscriviStudente(s, c);
	}
	
}
