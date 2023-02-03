import java.util.ArrayList;
import java.util.List;

public class Flotte {
    private String nom;
    private List<Vaisseau> listeVaisseaux;

    public Flotte(){
        this.nom = "Nouvelle Flotte";
        this.listeVaisseaux = new ArrayList<>();
    }

    public Flotte(String nom){
        this.nom = nom;
        this.listeVaisseaux = new ArrayList<>();
    }

    public String getNom(){
        return this.nom;
    }

    public void ajoute(Vaisseau vaisseau){
        this.listeVaisseaux.add(vaisseau);
    }

    public void ajoute(String nom, int puissance){
        this.listeVaisseaux.add(new Vaisseau(nom, puissance));
    }

    public void ajoute(String nom, int puissance, int passagers){
        this.listeVaisseaux.add(new Vaisseau(nom, puissance, passagers));
    }

    public int nombreVaisseaux(){
        return this.listeVaisseaux.size();
    }

    public int totalPuissance(){
        int total = 0;
        for (Vaisseau vaisseau : this.listeVaisseaux){
            total += vaisseau.getPuissance();
        }
        return total;   
    }

    public int nombreDeVaisseauxSansPassagers(){
        return 0;
    }

    public int puissanceDeFeuMax(){
        return 0;
    }

    public String nomDuVaisseauLeMoinsPuissant(){
        return "";
    }
}
