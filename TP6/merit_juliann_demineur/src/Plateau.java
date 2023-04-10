import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Classe Plateau
 */
public class Plateau {
    private int nbLignes;
    private int nbColonnes;
    private int pourcentageDeBombes;
    private int nbBombes;
    private List<List<CaseIntelligente>> lePlateau;

    /** Instancie un plateau de cases intelligentes
     *
     * @param nbLignes nombre de lignes du plateau
     * @param nbColonnes nombre de colonnes du plateau
     * @param pourcentage pourcentage de bombes sur le plateau
     */
    public Plateau(int nbLignes, int nbColonnes, int pourcentage) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.pourcentageDeBombes = pourcentage;
        this.lePlateau = new ArrayList<List<CaseIntelligente>>();
        this.creeLesCasesVides();
        this.rendLesCasesIntelligentes();
    }

    /** Permet d'ajouter des cases vides au plateau
     */
    private void creeLesCasesVides(){
        for (int i = 0; i < nbLignes; i++) {
            List<CaseIntelligente> ligne = new ArrayList<CaseIntelligente>();
            for (int j = 0; j < nbColonnes; j++) {
                ligne.add(new CaseIntelligente());
            }
            lePlateau.add(ligne);
        }
    }

    /**Permet de "donner" à chaque case toutes ses cases voisines
     */
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

    /** Permet de poser des bombes aléatoirement sur le plateau
     */
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

    /** Permet de savoir le nombre de ligne du plateau
     * @return int nombre de lignes
     */
    public int getNbLignes() {
        return this.nbLignes;
    }

    /** Permet de savoir le nombre de colonne du plateau
     *@return int nombre de colonnes
     */
    public int getNbColonnes() {
        return this.nbColonnes;
    }

    /** Permet de savoir le nombre de bombes du plateau
     * @return int nombre de bombes
     */
    public int getNbTotalBombes() {
        return this.nbBombes;
    }

    /** Permet d'avoir la case à la position x, y
     * @param numLigne numéro de la ligne
     * @param numColonne numéro de la colonne
     * @return CaseIntelligente case à la position x, y
     */
    public CaseIntelligente getCase(int numLigne, int numColonne){
        return this.lePlateau.get(numLigne).get(numColonne);
    }

    /** Permet de savoir le nombre de cases marquées
     * @return int nombre de cases marquées
     */
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

    /** Permet de poser une bombe à la position x, y
     * @param x numéro de la ligne
     * @param y numéro de la colonne
     */
    public void poseBombe(int x, int y){
        this.getCase(x, y).poseBombe();
    }

    /** Permet de remettre à zéro le plateau
     */
    public void reset(){
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                lePlateau.get(i).get(j).reset();
            }
        }
    }
}
