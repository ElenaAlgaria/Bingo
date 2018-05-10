/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo.Controller;


import Bingo.Main.Bingo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elena Algaria
 */
public class ViewController_1 implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label konto;
    
     

    @FXML
    void start(ActionEvent event) throws IOException {
      
        Stage stage = Bingo.getStage();
        Parent root;
       
            root = FXMLLoader.load(getClass().getResource("/Bingo/Views/View_2.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
         stage.setHeight(500);
        stage.setWidth(940);
       
       
    }

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
