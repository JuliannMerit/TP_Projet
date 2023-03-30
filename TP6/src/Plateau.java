import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plateau {
    private int nbLignes;
    private int nbColonnes;
    private int pourcentageDeBombes;
    private int nbBombes;
    private List<List<CaseIntelligente>> lePlateau;

    public Plateau(int nbLignes, int nbColonnes, int pourcentage) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.pourcentageDeBombes = pourcentage;
        this.lePlateau = new ArrayList<List<CaseIntelligente>>();
    }

    private void creeLesCasesVides(){
        for (int i = 0; i < nbLignes; i++) {
            List<CaseIntelligente> ligne = new ArrayList<CaseIntelligente>();
            for (int j = 0; j < nbColonnes; j++) {
                ligne.add(new CaseIntelligente());
            }
            lePlateau.add(ligne);
        }
    }

    //Permet de "donner" à chaque case toutes ses cases voisine
    private void rendLesCasesIntelligentes(){
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                CaseIntelligente caseCourante = lePlateau.get(i).get(j);
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <= j+1; l++) {
                        if (k >= 0 && k < nbLignes && l >= 0 && l < nbColonnes) {
                            caseCourante.ajouteVoisine(lePlateau.get(k).get(l));
                        }
                    }
                }
            }
        }
    }

    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }

    public int getNbLignes() {
        return this.nbLignes;
    }

    public int getNbColonnes() {
        return this.nbColonnes;
    }

    public int getNbTotalBombes() {
        return this.nbBombes;
    }

    public CaseIntelligente getCase(int numLigne, int numColonne){
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (i == numLigne && j == numColonne) {
                    return lePlateau.get(i).get(j);
                }
            }
        }
        return null;
    }

    public int getNbCasesMarquees(){
        int nbCasesMarquees = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (lePlateau.get(i).get(j).estMarquee()) {
                    nbCasesMarquees += 1;
                }
            }
        }
        return nbCasesMarquees;
    }

    public void poseBombe(int x, int y){
        getCase(x, y).poseBombe();
    }

    public void reset(){
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                lePlateau.get(i).get(j).reset();
            }
        }
    }
}
