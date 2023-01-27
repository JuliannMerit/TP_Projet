public class Vaisseau {
    private String nom;
    private int nombreDePassager;
    private int puissanceDeFeu;

    public Vaisseau(String nom, int puissance){
        this.nom = nom;
        this.puissanceDeFeu = puissance;
        this.nombreDePassager = 0;
    }

    public Vaisseau(String nom, int puissance, int passagers){
        this.nom = nom;
        this.puissanceDeFeu = puissance;
        this.nombreDePassager = passagers;
    }

    public String getNom(){
        return this.nom;
    }

    public int getNombrePassagers(){
        return this.nombreDePassager;
    }

    public int getPuissance(){
        return this.puissanceDeFeu;
    }

    public boolean transportePassagers(){
        return this.nombreDePassager > 0;
    }
}
