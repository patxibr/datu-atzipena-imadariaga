/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author root
 */
public class KalkulagailuaController implements Initializable {
    
    @FXML
    private Label batuketa, biderketa;
    
    @FXML
    private TextField batugai1,batugai2,biderkagai1,biderkagai2;
    @FXML
    private Button batu;
    @FXML
    private Button biderkatu;
    @FXML
    private TextField kengai1;
    @FXML 
    private TextField kengai2;
    @FXML
    private TextField zatigai1;
    @FXML
    private TextField zatigai2;
    @FXML
    private Button kendu;
    @FXML
    private Button zatitu;
    @FXML
    private Label kenketa;
    @FXML
    private Label zatiketa;
    @FXML
    private TextField berregai1;
    @FXML
    private TextField berregai2;
    @FXML
    private Button berretu;
    @FXML
    private Label berreketa;
    
    @FXML
    private void handleBatuAction(ActionEvent event) {
        System.out.println("Batuketa egin dugu.");
        batuketa.setText(""+(Double.parseDouble(batugai1.getText())+Double.parseDouble(batugai2.getText())));
    }

    @FXML
    private void handleBiderkatuAction(ActionEvent event) {
        System.out.println("Biderketa egin dugu.");
        biderketa.setText(""+(Double.parseDouble(biderkagai1.getText()) * Double.parseDouble(biderkagai2.getText())));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleKenduAction(ActionEvent event) {
        System.out.println("Kenketa egin dugu.");
        kenketa.setText(""+(Double.parseDouble(kengai1.getText()) - Double.parseDouble(kengai2.getText())));
    }

    @FXML
    private void handleZatituAction(ActionEvent event) {
        System.out.println("Zatiketa egin dugu.");
        zatiketa.setText(""+(Double.parseDouble(zatigai1.getText()) / Double.parseDouble(zatigai2.getText())));
    }

    @FXML
    private void handleBerretuAction(ActionEvent event) {
        System.out.println("Berreketa egin dugu.");
        double j = 1;
        for (double i = Double.parseDouble(berregai2.getText()); i>0; i--){
            j = j*Double.parseDouble(berregai1.getText());
        }
        berreketa.setText(""+j);
    }
    
}
