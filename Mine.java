/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

/**
 *
 * @author 33751
 */
public class Mine extends Case{
    
    public Mine(Plateau p,int lig,int col){
        super(p,lig,col);
        this.etatCase = 9;
        this.arreter= true;
        this.appelVois = 0;
    }
    
  public int getAppelVoi(){
     return this.appelVois;
    } 
  
     public void setAppelVoi(){
        this.appelVois = 1;
    }
        
     public int getEtatCase(){
        return this.etatCase;
    }
       
    public boolean getArreter(){
        return this.arreter;
    }
       
    public void active(){
        this.etatCase = 12;
        System.out.println(this.plt.runPlateau());
        System.out.println("Vous avez Malheureusement Perdu");
    }
}
