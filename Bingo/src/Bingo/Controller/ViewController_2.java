/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo.Controller;



import Bingo.Main.Bingo;
import Bingo.Model.GegnerSpielkarten;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elena Algaria
 */
public class ViewController_2 implements Initializable {

    @FXML
    private TextField zahl;

    @FXML
    private Button weiter;
    
    @FXML
    private Button abbrechen;
    
    @FXML
    private Button bingo;

    @FXML
    private Button verlassen;

    @FXML
    private Button neueZahl;

    @FXML
    private Label text1;

    @FXML
    private Label text2;
    @FXML
    private Label text0;
    @FXML
    private Label anzahlG;

    @FXML
    private Label gegner;

    @FXML
    private Label konto;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button b10;

    @FXML
    private Button b11;

    @FXML
    private Button b12;

    @FXML
    private Button b16;

    @FXML
    private Button b21;

    @FXML
    private Button b17;

    @FXML
    private Button b13;

    @FXML
    private Button b14;

    @FXML
    private Button b15;

    @FXML
    private Button b18;

    @FXML
    private Button b19;

    @FXML
    private Button b20;

    @FXML
    private Button b22;

    @FXML
    private Button b23;

    @FXML
    private Button b24;

    @FXML
    private Button b25;
    
    private int anzahl;
    
    private int aktuelleZufallszahl;

    ArrayList<Integer> usedNumbers = new ArrayList<>();
  public  ArrayList<Integer> usedNumbers2 = new ArrayList<>();

    private final int BOARD = 5;

    Button[][] button = new Button[BOARD][BOARD];
    

    Random rand = new Random();

    int n = rand.nextInt(75) + 1;
    

    Thread t = new Thread();
    
     
     GegnerSpielkarten gS;

      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        button[0][0] = b1;
        button[0][1] = b2;
        button[0][2] = b3;
        button[0][3] = b4;
        button[0][4] = b5;
        button[1][0] = b6;
        button[1][1] = b7;
        button[1][2] = b8;
        button[1][3] = b9;
        button[1][4] = b10;
        button[2][0] = b11;
        button[2][1] = b12;
        button[2][2] = b13;
        button[2][3] = b14;
        button[2][4] = b15;
        button[3][0] = b16;
        button[3][1] = b17;
        button[3][2] = b18;
        button[3][3] = b19;
        button[3][4] = b20;
        button[4][0] = b21;
        button[4][1] = b22;
        button[4][2] = b23;
        button[4][3] = b24;
        button[4][4] = b25;
              
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++) {
                button[i][j].setDisable(true);
                
            }
        }
        
        karteErstellen();
            
        gS = new GegnerSpielkarten(gegnerAnzahl());
        gS.setV2(this);
    }
    
    
  // erstellt eine Spielkarte mit zufälligen Zahlen von 1 bis 75. 
    public void karteErstellen() {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++) {
                do {
                    n = rand.nextInt(75) + 1;
                } while ((usedNumbers.contains(n)));
                usedNumbers.add(n);
                button[i][j].setText(Integer.toString(n));
  
            }

        }
    }

    @FXML
    public void weiter(ActionEvent event) throws InterruptedException, IOException {

        text0.setVisible(false);
        text1.setVisible(true);
        text2.setVisible(true);
        weiter.setVisible(false);
        zahl.setVisible(true);
        bingo.setVisible(true);
        verlassen.setVisible(true);
        gegner.setVisible(true);
        anzahlG.setVisible(true);
        text2.setVisible(true);
        neueZahl.setVisible(true);
        abbrechen.setVisible(false);
        
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++) {
      
                  button[i][j].setDisable(false);
            }
        }
     
         
    
    }
    
     @FXML
    public void abbrechen(ActionEvent event) throws InterruptedException, IOException {

        Platform.exit();
        
       
    }
    
     // ein timer der von 1 bis 0 runterzählt
    public void timer() throws InterruptedException {

        for (int i = 1; i >= 0; i--) {

            t.sleep(1000);
            System.out.println(i);
        }

    }
    // erstellt eine neue Zufallszahl von 1 bis 75
    @FXML
    public void neueZahl(ActionEvent event) throws InterruptedException, IOException {

        timer();
        do {
            n = new Random().nextInt(75) + 1;
        } while ((usedNumbers2.contains(n)));
        usedNumbers2.add(n);

        zahl.setText(Integer.toString(n));
        
        this.aktuelleZufallszahl = n;
        gS.eintrag();
         gS.check();

    }

    public int getAktuelleZufallszahl() {
        return aktuelleZufallszahl;
    }

    
      // erstellt eine Radnom Gegner Anzahl von 1 - 5
      public int gegnerAnzahl(){
     
        anzahl = rand.nextInt(5) + 1;
       
        gegner.setText(Integer.toString(anzahl));
        
         return anzahl;
    }

    @FXML
    public void bingo(ActionEvent event) throws IOException {

        zahlenKontrolliern();

    }
    
    
   // kontrolliert die markierten Zahlen, ob sie gleich sind wie die Zahlen die schon gezogen wurden und ob sie in einer 5er Reihe liegen
    public void zahlenKontrolliern() throws IOException {
        
        int selectedNumbers = 0;
      // diagonal von links oben nach rechts unten
        for (int i = 0; i < BOARD; i++) {
            if (button[i][i].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[i][i].getText()))) {
                selectedNumbers++;
            }

        }
        if (selectedNumbers == 5) {
                gewonnen();
                 return;
                
            }else {
                verloren();
            } 
        
        selectedNumbers = 0;
        
        // diagonal von rechts oben nach links unten
        if(button[0][4].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[0][4].getText()))) selectedNumbers++;
        if(button[1][3].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[1][3].getText()))) selectedNumbers++;
        if(button[2][2].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[2][2].getText()))) selectedNumbers++;
        if(button[3][1].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[3][1].getText()))) selectedNumbers++;
        if(button[4][0].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[4][0].getText()))) selectedNumbers++;
        
       
        if (selectedNumbers == 5) {
                 gewonnen();
                 return;
               
            } else {
                verloren();
            }
        
        selectedNumbers = 0;
        
        // horizontal
        for (int i = 0; i < BOARD; i++) {
            for (int j = 0; j < BOARD; j++) {
                if (button[i][j].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[i][j].getText()))) {
                    selectedNumbers++;

                }
            }
            if (selectedNumbers == 5) {
                  gewonnen();
                  return;
                
            } else{
              
                verloren();
            }
            
             }
        selectedNumbers = 0;
          
         // vertikal 
        for (int i = 0; i < BOARD; i++) {
            for (int j = 0; j < BOARD; j++) {
                if (button[j][i].getStyle() == "-fx-background-color: red" && usedNumbers2.contains(Integer.parseInt(button[j][i].getText()))) {
                    selectedNumbers++;

                }
                
            if (selectedNumbers == 5) {
                
                  gewonnen();
                return;
                
            }else{
                verloren();
            }
            
          
        }
     

        

    }

}
 public void gewonnen() throws IOException {
               
        Stage stage = Bingo.getStage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/Bingo/Views/View_3.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
         stage.setHeight(500);
        stage.setWidth(940);

    }

    
    public void verloren() throws IOException {
               
        Stage stage = Bingo.getStage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/Bingo/Views/View_4.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
         stage.setHeight(500);
        stage.setWidth(940);

    }

  
    @FXML
    public void verlassen(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void click(ActionEvent event) {

        Button selectedButton = (Button) event.getSource();
        selectedButton.setStyle("-fx-background-color: red");

     

    }
   
    
    
    
    
    
    


}
