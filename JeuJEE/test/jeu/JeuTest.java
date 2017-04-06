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
    
    public JeuTest(ArrayList<Action> listAction) {
        this.jeu = new Jeu();
        this.listAction = listAction;
        
    }
    


    /**
     * Test du jeu via le tableau d'action donné en paramètre
     */
    @Test
    public void testJeu() {
        jeu.initialisation();
        for (Action action : listAction) {
            assertEquals(jeu.action(action.getJoueur(), action.getAction()), action.getResult());
        }
       
    }
  
    /**
     * Test que le joueur 3 n'existe pas
     */
    @Test
    public void testAction() {
        jeu.initialisation();
        assertFalse(jeu.action(3,1));
        
       
    }
}

