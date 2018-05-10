/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo.Model;


import Bingo.Controller.ViewController_2;
import Bingo.Controller.ViewController_5;
import Bingo.Main.Bingo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Elena Algaria
 */
public class GegnerSpielkarten {

    ViewController_2 v2;
    
  private String gewinner;
     

    public ArrayList<GegnerSpielkarte> spielkarten = new ArrayList();
    public ArrayList<String> namen = new ArrayList();
   

    public GegnerSpielkarten(int anzahl) {
        anzahlSpielkarten(anzahl);
         
    }

    public void setV2(ViewController_2 v2) {
        this.v2 = v2;
    }

   
    // erstellt Random Gegner Spielkarten 
    public void anzahlSpielkarten(int gegnerAnzahl) {

        for (int i = 0; i < gegnerAnzahl; i++) {
            spielkarten.add(new GegnerSpielkarte());

        }

    }
    // falls die gezogene Zahl auf einer Gegner Spielkarte ist, wird sie markiert
    // mit 1111
    public void eintrag() {

        for (GegnerSpielkarte g : spielkarten) {
            for (int i = 0; i < g.karte.length; i++) {
                for (int j = 0; j < g.karte.length; j++) {
                    int tmp = v2.getAktuelleZufallszahl();
                    if (g.karte[i][j] == tmp) {
                        g.karte[i][j] = 1111;

                    }
                }
            }
        }

    }

    public void check() throws IOException, InterruptedException {
        for (GegnerSpielkarte g : spielkarten) {
            gegnerKarteKontrollieren(g);
        }
    }
 // kontrolliert die Gegner Spielkarte, ob die Zahlen gleich sind wie die Zahlen
 // die schon gezogen wurden und ob sie in einer 5er Reihe liegen
    public void gegnerKarteKontrollieren(GegnerSpielkarte gS) throws IOException, InterruptedException {

        int selectedNumbers = 0;
        // diagonal von links oben nach rechts unten
        for (int i = 0; i < gS.BOARD; i++) {
            if (gS.karte[i][i] == 1111) {
                selectedNumbers++;
            }

        }
        if (selectedNumbers == 5) {

            getGewinner(gS);
            gegnerGewinnt();

        }

        selectedNumbers = 0;

        // diagonal von rechts oben nach links unten
        if (gS.karte[0][4] == 1111) {
            selectedNumbers++;
        }
        if (gS.karte[1][3] == 1111) {
            selectedNumbers++;
        }
        if (gS.karte[2][2] == 1111) {
            selectedNumbers++;
        }
        if (gS.karte[3][1] == 1111) {
            selectedNumbers++;
        }
        if (gS.karte[4][0] == 1111) {
            selectedNumbers++;
        }

        if (selectedNumbers == 5) {
            getGewinner(gS);
            gegnerGewinnt();

        }
        selectedNumbers = 0;

        // horizontal
        for (int i = 0; i < gS.BOARD; i++) {
            for (int j = 0; j < gS.BOARD; j++) {
                if (gS.karte[i][j] == 1111) {
                    selectedNumbers++;

                }
            }
            if (selectedNumbers == 5) {
                getGewinner(gS);
                gegnerGewinnt();

            }

        }
        selectedNumbers = 0;

        // vertikal 
        for (int i = 0; i < gS.BOARD; i++) {
            for (int j = 0; j < gS.BOARD; j++) {
                if (gS.karte[j][i] == 1111) {
                    selectedNumbers++;

                }

                if (selectedNumbers == 5) {
                    getGewinner(gS);
                    gegnerGewinnt();

                }

            }

        }

    }

    public void getName() {

        namen.add("Rose");
        namen.add("Ruby");
        namen.add("Graham");
        namen.add("Wayne");
        namen.add("Rosann");
       

    }
  // nimmt den Index von der Spielkarte die gewonnen hat aus der ArrayList 
  // spielkarten
    public String getGewinner(GegnerSpielkarte gS) {
         
         getName();
        gewinner = namen.get(spielkarten.indexOf(gS));
        
        return gewinner;
    }
    

    public void gegnerGewinnt() throws IOException {

        Stage stage = Bingo.getStage();
        Parent root;
       
        FXMLLoader loader = new 
        FXMLLoader(getClass().getResource("/Bingo/Views/View_5.fxml"));
        
        
        Scene scene = new Scene((Pane)loader.load());
        stage.setScene(scene);
        
          ViewController_5 v5  = loader.<ViewController_5>getController();
        v5.setName(gewinner);
        
        stage.show();
        stage.setResizable(false);
         stage.setHeight(500);
        stage.setWidth(940);

    }

}
