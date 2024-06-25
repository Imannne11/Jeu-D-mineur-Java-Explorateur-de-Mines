package projet;

public class Plateau {
  
    private int dim;
    private int nmbMines;
    private int nmbCaseVide;
    private String[][] tabA;
    private Case[][] tabNA;

    public Plateau(int nb,int d){
        this.nmbMines = nb;
        this.dim = d;
        this.nmbCaseVide = 0;
        this.tabNA = new Case[dim][dim];
        this.tabA = new String[dim][dim];
    }
    
    public int getNmbMines(){
        return this.nmbMines;
    }
    
    public Case getCase(int l,int c) {
        return this.tabNA[l][c];
    }
      
    public Case[][] getTabNA(){
        return this.tabNA;
    }
    
    public void setTabNA(Case[][] k){
        this.tabNA = k;
    }
    
    public int getDim(){
        return dim;
    }
      
  public void setCase(int l,int c,int val){
        if(val == 0)
            tabA[l][c] = "{ "+" "+" }";
        else               
            tabA[l][c] = "{ "+val+" }";
    }  
   
    public int getNmbCase(){
        return this.nmbCaseVide;
    }
    
    public void setNmbCase(int n){
       this.nmbCaseVide = n;
    }
        
   public void initPlateauCase(){
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                tabNA[i][j] = new Vide(this,i,j,0); 
                this.nmbCaseVide++;
            }
        }
    }
    
    public void ajoutMine(){
       int nb=0;
       while(nb < nmbMines){
           int i = (int) (Math.random()*dim);
           int j = (int) (Math.random()*dim);
           if(tabNA[i][j].getEtatCase() != 9){
           this.tabNA[i][j] = new Mine(this,i,j);
           nb++;
           this.nmbCaseVide--;
           }
       }
       
       for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(tabNA[i][j].getEtatCase() == 9){    
                      for (int k = (i-1) ; k <= (i+1) ; k++){
                        for (int l = (j-1) ; l <= (j+1) ; l++)  {
                            if(k>=0 && k<dim && l>=0 && l<dim){
                                if(tabNA[k][l].getEtatCase() != 9){
                                    tabNA[k][l] = new Vide(this,k,l,tabNA[k][l].getEtatCase()+1);
                                }
                        }
            }
            }
                                                 
            }
       }
            
    }
    }
    
     public String runPlateau(){
        String s ="";
         for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(j == dim-1){
                    if(tabNA[i][j].getEtatCase() == 9)
                         s+=  "{ "+"m"+" } ";
                    else if(tabNA[i][j].getEtatCase() == 12)
                         s+= "{ "+"*"+" } ";  
                    else
                        s+= "{ "+tabNA[i][j].getEtatCase()+" } ";
                    s+="\n";
                }
                else
                     if(tabNA[i][j].getEtatCase() == 9)
                         s+=  "{ "+"m"+" } ";
                    else if(tabNA[i][j].getEtatCase() == 12)
                         s+= "{ "+"*"+" } ";  
                    else
                        s+= "{ "+tabNA[i][j].getEtatCase()+" } ";  
                }
            }
            
         return s;
    }
     
        public void remplirPlateau(){
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                tabA[i][j] = "{"+i+";"+j+"}"; 
            }
        }
    }
    
    public String affichagePlateau(){
        String s ="";
         for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(j == dim-1){
                s+= tabA[i][j]+" ";
                s+="\n";
                }
                else
                s+= tabA[i][j]+" ";
            }
            }
         return s;
    }
     
}