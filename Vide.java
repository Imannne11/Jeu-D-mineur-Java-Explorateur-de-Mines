/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

/**
 *
 * @author 33751
 */
public class Vide extends Case{
    
     public Vide(Plateau plt,int lig,int col,int i){ 
        super(plt,lig,col);
        this.etatCase = i;
        this.arreter = false;
        this.appelVois = 0;
    }
     
    public int getAppelVois(){
        return this.appelVois;
    } 
    
    public void setAppelVois(){
        this.appelVois = 1;
    }
           
    public int getEtatCase(){
        return this.etatCase;
    }
    
       public boolean getArreter(){
        return this.arreter;
    } 

    public void active(){
       floodFill(plt,ligne,colonne,1);
        if(plt.getNmbCase() !=0){
        System.out.println(this.plt.affichagePlateau());
        }
        else{
        System.out.println("Bravo,Vous avez gagné!!!");    
        System.out.println(this.plt.runPlateau());     
        }
    }
    
   public void floodFill(Plateau tab, int lig, int col,int nouveau){
        int avant = tab.getCase(lig,col).getAppelVois();
        fill(tab,lig,col,avant,nouveau);
    }
    
    public static void fill(Plateau  tab,int l, int c,int avant,int nouveau){
       if(l<0 || l >=tab.getDim() || c<0  || c>=tab.getDim())
           return;
      if(tab.getCase(l,c).getAppelVois() != avant)
          return;
      if(tab.getCase(l,c).getEtatCase() == 9)
          return;
      
        tab.setNmbCase(tab.getNmbCase()-1);
        tab.getCase(l,c).setAppelVois();
        tab.setCase(l,c,tab.getCase(l,c).getEtatCase());
        
        if(l+1<10 && tab.getCase(l+1,c).getEtatCase() != 9){
           fill(tab,l+1,c,avant,nouveau);
        }
        else
            return;
        if(l-1>=0 && tab.getCase(l-1,c).getEtatCase() != 9){ 
            fill(tab,l-1,c,avant,nouveau);
        }
        else
            return;
        if(c+1<10 && tab.getCase(l,c+1).getEtatCase() != 9){
            fill(tab,l,c+1,avant,nouveau);
        }
        else
            return;
        if(c-1>=0 && tab.getCase(l,c-1).getEtatCase() != 9) {
            fill(tab,l,c-1,avant,nouveau);     
        }
        else
            return;
    }

}

