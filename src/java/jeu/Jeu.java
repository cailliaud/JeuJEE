/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.ArrayList;

/**
 *
 * @author caill
 */
public class Jeu implements API{
    private int[][] plateau;
    private int nbJ1 ;
    private int nbJ2 ;
    private String statut;
    private int lastAction;

    @Override
    public void initialisation() {
        this.plateau = new int[8][8];
        this.plateau[4][4] = 1;
        this.plateau[5][5] = 1;
        this.plateau[4][5] = 2;
        this.plateau[5][4] = 2;
        this.nbJ1 = 2;
        this.nbJ2 = 2;
        this.statut="joueur1";
        this.lastAction = 0;
        
        
    }

    @Override
    public boolean action(int player, int action) {
        Position pos = new Position(action); // conversion d'action en position
        
        if (this.statut.equals("finie")) return false;
        if (!posExist(pos))return false; // test si position donnée existe
        if (!caseVide(pos)) return false; // test si case vide;
       
        
        Boolean aTrouve = false; // Test des 8 directions possibles
        aTrouve = aTrouve || checkDirection( pos , -1,-1 ,  player);
        aTrouve = aTrouve || checkDirection( pos , -1,0 ,  player);
        aTrouve = aTrouve || checkDirection( pos , -1,1,  player);
        aTrouve = aTrouve || checkDirection( pos , 0,1 ,  player);
        aTrouve = aTrouve || checkDirection( pos , 1,1 ,  player);
        aTrouve = aTrouve || checkDirection( pos , 1,0,  player);
        aTrouve = aTrouve || checkDirection( pos , 1,-1 ,  player);
        aTrouve = aTrouve || checkDirection( pos , 0,-1 ,  player);
             
        if (aTrouve){
            calculScorePerso();
            this.lastAction = action;
            this.statut= (this.nbJ1+this.nbJ2==64)? "finie" : (player==1) ? "joueur2":"joueur1";
            return true;
        }
        return false;
    }
    
    private boolean checkDirection(Position pos , int l, int c , int player){
        if (posExist(pos.addVecteur(l,c)) && !memeJeton(player,pos.addVecteur(l,c))){
            return goDirection( pos,  player , 0,-1);
        } else {
            return false;
        }
    }
    private void calculScorePerso(){
        for (int i = 1; i < 8; i++) {
            for (int j = 1 ; j<8 ; j++){
                if (plateau[i][j]==1){
                    this.nbJ1++;
                }else if (plateau[i][j]==2){
                    this.nbJ2++;
                }
            }
            
        }
    }
    
    private boolean memeJeton(int joueur , Position pos){
        return (plateau[pos.getLigne()][pos.getColonne()]==joueur);
    }
    private boolean goDirection (Position pos, int joueur , int l, int c){
        ArrayList<Position> liste = new ArrayList<>();
        liste.add(pos);
        
        pos = pos.addVecteur(l,c);
        liste.add(pos);
        
        while(posExist(pos.addVecteur(l,c))){
            if(memeJeton(joueur, pos)){
                retourneJeton(liste, joueur);
                return true;
            }else {
                pos = pos.addVecteur(l,c);
                liste.add(pos);
            }     
        }
        return false;
    }

    
    private boolean posExist(Position pos){
        if (pos.getLigne()<1 || pos.getLigne()>8) { // test de la dizaine
            return false;
        } 
        return (pos.getColonne()<1 ||pos.getColonne()>8);
    }
    
    private boolean caseVide(Position pos){
        return (plateau[pos.getLigne()][pos.getColonne()]==0);
    }
        
    
    
    private void retourneJeton( ArrayList<Position> listeJeton, int joueur){
        listeJeton.forEach((pos) -> {
            plateau[pos.getLigne()][pos.getColonne()] = joueur;
        });
    }

    @Override
    public String statut() {
       return this.statut;
    }

    @Override
    public int derniereAction() {
        return this.lastAction;
    }

    @Override
    public String affichage() {
        String info = "Joueur 1 = "+this.nbJ1+" jetons.\nJoueur2 = "+ this.nbJ2 + " jetons.";
        return info;
    }
    
}
