/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

/**
 *
 * @author 33751
 */
public class Jeu {

    private int coup;
    private boolean etat;
    private Plateau plt;
        
    public Jeu(){
        this.etat = false;
        this.coup = 0;
    }
    
       
    public void joue(){
        int l,c,dif,dim,n;
        do{
        System.out.println("Choisissez le niveau de difficulté");
        dif = Lire.i();
        System.out.println("Saisir la dimension");
        dim = Lire.i();
        }while(dif>10);
        n = (dim*dim*dif)/10;
        this.plt = new Plateau(n,dim);
        
        
        this.plt.initPlateauCase();
        this.plt.remplirPlateau();
        this.plt.ajoutMine();
        
        System.out.println(this.plt.affichagePlateau());
        System.out.println(this.plt.runPlateau());
        System.out.println("Le nombre de mine trouvée est:" + n);
      
        do{
        do{
            System.out.println("Le nombre de case vide trouvée est:" + plt.getNmbCase());
            System.out.println("Le nombre de coup est: " + this.coup);
            System.out.println("veuillez sélectionner une case dans la grille");
            System.out.println("Ligne est:");
            l = Lire.i();
            System.out.println("Colonne est:");
            c = Lire.i();
        }while(l>dim || c>dim);
       
        if(plt.getCase(l,c).getEtatCase() == 9){
                plt.getCase(l,c).active();
                this.etat = true;
                this.coup++;
        }
        else{
                plt.getCase(l,c).active();
                this.etat = false;
                this.coup++;
        }
        
        }while(plt.getNmbCase() != 0 && this.etat == false);
    }
}
