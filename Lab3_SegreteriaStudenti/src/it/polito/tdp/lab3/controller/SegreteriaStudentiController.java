package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.SegreteriaStudentiModel;
import it.polito.tdp.lab3.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private SegreteriaStudentiModel model;	
	
    public void setModel(SegreteriaStudentiModel model) {
		this.model = model;
		cmbCorso.getItems().addAll(model.popolaTendina());
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> cmbCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtRes;

    @FXML
    private Button btnReset;

    @FXML
    void doCerca(ActionEvent event) {
    	
    	
    	if(cmbCorso.getValue().getCrediti()==-1&&txtMatricola.getText().compareTo("")!=0){
    		//ELENCO CORSI SEGUITI DA STUDENTE X
    		Studente s=this.checkStudente();
    		if(s==null)
    			return;
    		String str="";
    		try {
				for(Corso c:model.corsiStudente(s)){
					str+=c.stampati()+"\n";    			
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				txtRes.setText("NESSUN CORSO SEGUITO");
			}
    		txtRes.setText(str);
    		
    		
    		
    	}
    	if(cmbCorso.getValue()==null){
    		txtRes.setText("CORSO NON SELEZIONATO");
    		return;
    	}
    	
    	if(cmbCorso.getValue()!=null&&txtMatricola.getText().compareTo("")!=0){
    		//STUDENTE S ISCRITTO A CORSO C
    		
    		
    	}    	
    	else{
    		//ELENCO STUDENTI ISCRITTI A CORSO C    		
    		List<Studente> temp=null;
			try {
				temp = new ArrayList<Studente>(model.iscrittiAcorso(cmbCorso.getValue()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				txtRes.setText("NESSUNO STUDENTE ISCRITTO AL CORSO");
			}  
			String s="";
			for(Studente st:temp){
				s+=st+"\n";
			}
    		txtRes.setText(s);
    		return;
    		
    	}

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    		
    	
    }

    @FXML
    void doLogin(ActionEvent event) {
    	this.checkStudente();
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtNome.clear();
    	txtCognome.clear();
    	txtMatricola.clear();
    	txtRes.clear();
    	cmbCorso.setValue(null);
    	btnLogin.setDisable(false);

    }
    
    public Studente checkStudente(){
    	btnLogin.setDisable(true);
    	if(txtMatricola.getText().compareTo("")==0){
    		txtRes.setText("ERRORE: Inserisci la matricola");
    		return null;
    	}
    		
    	Studente s=model.cercaStudente(txtMatricola.getText());
    	if(s==null){
    		txtRes.setText("ERRORE: Studente assente");
    		return null;
    	}
    	txtNome.setText(s.getNome());;
    	txtCognome.setText(s.getCognome());
    	return s;
    }

    @FXML
    void initialize() {
        assert cmbCorso != null : "fx:id=\"cmbCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtRes != null : "fx:id=\"txtRes\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
}
