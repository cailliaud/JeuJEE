/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

/**
 *
 * @author caill
 */
public class Main {
    
    public static void  main (){
        Jeu jeu = new Jeu();
        jeu.initialisation();
        jeu.action(1, 1);
        jeu.action(1,2);
        jeu.action(2,3);
        int lastAction = jeu.derniereAction();
        
        
    }
    
}
