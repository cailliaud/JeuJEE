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
public class Position {
    private int ligne;
    private int colonne;
    
    public Position(int position){
        this.ligne = (position/10);
        this.colonne = (position%10); 
   
      
        

    }
    
    public int getLigne(){
        return this.ligne;
    }
    
    public int getColonne(){
        return this.colonne;
    }
    
    public Position addVecteur( int l , int c){
        Position newPos = new Position(0);
        newPos.colonne = this.colonne + c;
        newPos.ligne = this.ligne+ l;
        return (newPos);
    }
    
    @Override
    public String toString(){
        return "Ligne : "+this.ligne+" ;Colonne : "+this.colonne;
    }
}
