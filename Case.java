/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

/**
 *
 * @author 33751
 */
public abstract class Case {
    protected boolean arreter;
    protected int appelVois;
    protected Plateau plt;
    protected int etatCase;
    protected int ligne;
    protected int colonne;
    protected int nmbCase;
    
    public Case(Plateau p, int lig, int col){  
            this.plt = p;
            this.ligne = lig;
            this.colonne = col;
    }
    
    public abstract boolean getArreter();
         
    public abstract int getEtatCase();
    
    public abstract void active();

   public int getAppelVois(){
        return this.appelVois;
    }
   
   public void setAppelVois(){
        this.appelVois= 1;
    }
         

}
