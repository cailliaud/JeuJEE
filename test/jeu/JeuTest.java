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
        this.listAction.add(new Action(0, 0, false));
        this.listAction.add(new Action(1, 65, true));
        this.listAction.add(new Action(2, 66, true));
        this.listAction.add(new Action(1,22, false));
        this.listAction.add(new Action(1, 67, true));
        this.listAction.add(new Action(2, 75, true));
        this.listAction.add(new Action(1, 75, false));
        this.listAction.add(new Action(1, 85, true));
        this.listAction.add(new Action(2, 77, true));
        //testJeu();
    }
    

    
   
    /**
     * Test du jeu via le tableau d'action donné en paramètre
     */
    @Test
    public void testAction() {
        jeu.initialisation();
        assertEquals(jeu.action(0, 0),false);
        //assertEquals(
        //       jeu.action(a.getJoueur(), a.getAction()),
        //       a.getResult());  
    }
  
}

