import java.util.ArrayList;
import java.util.List;
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
        for (int i = 0; i < nbLignes; i++) {
            List<CaseIntelligente> ligne = new ArrayList<CaseIntelligente>();
            for (int j = 0; j < nbColonnes; j++) {
                ligne.add(new CaseIntelligente());
            }
            lePlateau.add(ligne);
        }
    }

    private void creeLesCasesVides(){

    }

    private void rendLesCasesIntelligentes(){

    }

    protected void poseDesBombesAleatoirement(){

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
        return new CaseIntelligente();
    }

    public int getNbCasesMarquees(){
        return 0;
    }

    public void poseBombe(int x, int y){

    }

    public void reset(){
        
    }
}
