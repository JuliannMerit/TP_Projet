public class Plateau {
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    private int pourcentageBombes;
    private List<List<Case>> lesCases;

    public Plateau(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.pourcentageBombes = (nbBombes * 100) / (nbLignes * nbColonnes);
        this.lesCases = new ArrayList<List<Case>>();
        for (int i = 0; i < nbLignes; i++) {
            List<Case> ligne = new ArrayList<Case>();
            for (int j = 0; j < nbColonnes; j++) {
                ligne.add(new Case());
            }
            lesCases.add(ligne);
        }
    }
    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }
}
