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
public class Action {
    
        private int joueur;
        private int action;
        private boolean result;

        public Action (int joueur, int action, boolean expected){
            this.joueur=joueur;
            this.action=action;
            this.result=expected;
        }

    public int getJoueur() {
        return joueur;
    }


    public int getAction() {
        return action;
    }
    
    public boolean getResult(){
        return this.result;
    }

        
        

    
    
}
