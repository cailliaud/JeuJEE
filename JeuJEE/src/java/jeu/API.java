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
public interface API {
    
    public  void initialisation();
    public boolean action(int player , int action);
    public String statut();
    public int derniereAction();
    public String affichage();
    
    
    
    
}
