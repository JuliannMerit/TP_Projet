import javax.print.CancelablePrintJob;

public class Champion {
    private String nom;
    private int pointsDeVie;
    private int attaque;
    private int soin;

    public Champion(String nom, int pointsDeVie, int attaque, int soin){
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.attaque = attaque;
        this.soin = soin;
    }

    public void combat(Champion adversaire){
        this.pointsDeVie -= adversaire.attaque;
        adversaire.pointsDeVie -= this.attaque;
    }

    public void boitUnePotionDeSoin(){
        this.pointsDeVie += 5;
    }

    public void soigne(Champion championBlesse){
        championBlesse.pointsDeVie += this.soin;
    }

    public boolean estEnVie(){
        return pointsDeVie>0;
    }
}
