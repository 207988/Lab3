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

}
