/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caill
 */
public class JeuTest {
    private  Jeu jeu;
    private ArrayList<Action> listAction;
    

    public JeuTest() {
        this.jeu = new Jeu();
        this.listAction = new ArrayList<>();
       // this.listAction.add(new Action(0, 0, false));
        this.listAction.add(new Action(1, 64, true));
        this.listAction.add(new Action(2, 65, true));
        //this.listAction.add(new Action(1,22, false));
        this.listAction.add(new Action(1, 66, true));
        this.listAction.add(new Action(2, 75, true));
        this.listAction.add(new Action(1, 75, false));
        this.listAction.add(new Action(1, 46, true));
        this.listAction.add(new Action(2, 47, false));
        //testJeu();
    }
    

    
   
    /**
     * Test du jeu via le tableau d'action donné en paramètre
     */
    @Test
    public void testAction() {
        jeu.initialisation();
        System.out.println(jeu.affichage());
        for (Action a : listAction) {
            System.out.println(""+a.getJoueur()+" "+a.getAction()+" "+a.getResult());
            
            assertEquals(a.getResult(),  jeu.action(a.getJoueur(), a.getAction())); 
            System.out.println(jeu.affichage());
        }
       
    }
  
}

