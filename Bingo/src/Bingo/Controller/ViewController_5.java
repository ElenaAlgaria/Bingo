package Bingo.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Elena Algaria
 */
public class ViewController_5 implements Initializable {

    @FXML
    public  Label gegnerZahl;

     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
   
    }    
    
   
    
    public void setName(String name) {
        gegnerZahl.setText(name);
    }
    
    @FXML
    private void schliessen(ActionEvent event) {
        Platform.exit();
    }

    
}
