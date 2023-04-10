import java.util.Scanner;

/** Classe Demineur
 */
public class Demineur extends Plateau{
    private boolean gameOver;
    private int score;

    /** Instancie un plateau de cases intelligentes
     * @param nbLignes le nombre de lignes du plateau
     * @param nbColonnes le nombre de colonnes du plateau
     * @param pourcentage le pourcentage de bombes sur le plateau
     */
    public Demineur(int nbLignes, int nbColonnes, int pourcentage){
        super(nbLignes, nbColonnes, pourcentage);
        this.gameOver = false;
        this.score = 0;
    }

    /** Permet de savoir le score du joueur
     * @return int score du joueur
     */
    public int getScore(){
        return this.score;
    }

    /** Permet de reveler une case
     * @param x int abscisse de la case
     * @param y int ordonnée de la case
     */
    public void reveler(int x, int y){
        if(!super.getCase(x, y).estMarquee()){
            super.getCase(x, y).reveler();
            score += 1;
        }
    }

    /** Permet de marquer une case
     * @param x int abscisse de la case
     * @param y int ordonnée de la case
     */
    public void marquer(int x, int y){
        if(!super.getCase(x, y).estDecouverte()){
            super.getCase(x, y).marquer();
        }
    }

    /** Permet de savoir si la partie est gagnée
     *@return boolean true si la partie est gagnée, false sinon
     */
    public boolean estGagnee(){
        int res = 0;
        for (int i = 0; i < getNbLignes(); i++) {
            for (int j = 0; j < getNbColonnes(); j++){
                if(super.getCase(i, j).estDecouverte()){
                    res+=1;
                }
            }
        }
        return super.getNbLignes()*super.getNbColonnes() - res == super.getNbTotalBombes();
    }

    /** Permet de savoir si la partie est perdue
     * @return boolean true si la partie est perdue, false sinon
     */
    public boolean estPerdue(){
        for (int i = 0; i < getNbLignes(); i++) {
            for (int j = 0; j < getNbColonnes(); j++){
                if(super.getCase(i, j).estDecouverte()){
                    if (super.getCase(i, j).contientUneBombe()){
                        gameOver = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** Permet de remettre à zéro la partie
     */
    public void reset(){
        this.gameOver = false;
        this.score = 0;
    }

    /** Permet d'afficher le plateau
     */
    public void affiche(){
        System.out.println("JEU DU DEMINEUR");
        // affichage de la bordure supérieure
        System.out.print("  ");
        for (int j=0; j<this.getNbColonnes(); j++){
            System.out.print("  "+j+" ");
        }
        System.out.print(" \n");

        // affichage des numéros de ligne + cases
        System.out.print("  ┌");
        for (int j=0; j<this.getNbColonnes()-1; j++){
            System.out.print("───┬");
        }
        System.out.println("───┐");

        // affichage des numéros de ligne + cases
        for (int i = 0; i<this.getNbLignes(); i++){
            System.out.print(i+" ");
            for (int j=0; j<this.getNbColonnes(); j++){
                System.out.print("│ "+this.getCase(i, j).toString() + " ");
            }
            System.out.print("│\n");

            if (i!=this.getNbLignes()-1){
                // ligne milieu
                System.out.print("  ├");
                for (int j=0; j<this.getNbColonnes()-1; j++){
                    System.out.print("───┼");
                }
                System.out.println("───┤");
            }
        }

        // affichage de la bordure inférieure
        System.out.print("  └");
        for (int j=0; j<this.getNbColonnes()-1; j++){
            System.out.print("───┴");
        }
        System.out.println("───┘");

        // affichage des infos
        System.out.println("Nombres de bombes à trouver : " + this.getNbTotalBombes());
        System.out.println("Nombres de cases marquées : " + this.getNbCasesMarquees());
        System.out.println("Score : " + this.getScore());
    }

    /** Permet de lancer une partie
     */
    public void nouvellePartie(){
        this.reset();
        this.poseDesBombesAleatoirement();
        this.affiche();
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        while (!this.estPerdue() && !this.estGagnee()){
            System.out.println("Entrer une instruction de la forme R 3 2 ou M 3 2\npour Révéler/Marquer la case à la ligne 3 et à la colonne 2");
            String [] s = scan.nextLine().split(" ");
            String action = s[0];
            int x = Integer.valueOf(s[1]);
            int y = Integer.valueOf(s[2]);
            if (action.equals("M") || action.equals("m"))
                this.marquer(x, y);
            else if (action.equals("R") || action.equals("r"))
                this.reveler(x, y);
            this.affiche();
        }
        if (this.gameOver){
            System.out.println("Oh !!! Vous avez perdu !");
        }
        else{
            System.out.println("Bravo !! Vous avez gagné !");
        }
    }
}