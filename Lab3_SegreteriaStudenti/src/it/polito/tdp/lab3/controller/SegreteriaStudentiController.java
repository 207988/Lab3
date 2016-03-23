package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.SegreteriaStudentiModel;
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

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doLogin(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

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
