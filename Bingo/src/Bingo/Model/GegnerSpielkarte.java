/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo.Model;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Elena Algaria
 */
public class GegnerSpielkarte {
        
    public  final int BOARD = 5;
    
    public  Integer[][] karte = new Integer[BOARD][BOARD]; 
   

    private Random rand = new Random();
    private  int n = rand.nextInt(75) + 1;
    
   private ArrayList<Integer> usedNumbers = new ArrayList<>();
   
    

    public GegnerSpielkarte() {
    
    gegnerKarteErstellen();
    
    
    }
    // erstellt eine Spielkarte mit Zahlen von 1 bis 75
 public void gegnerKarteErstellen(){
     
     for (int i = 0; i < karte.length; i++) {
            for (int j = 0; j < karte.length; j++) {
                do {
                    n = rand.nextInt(75) + 1;
                } while ((usedNumbers.contains(n)));
                usedNumbers.add(n);
               karte[i][j] = n;
                          
               }
    
               }    
   
             }
               
 















}
