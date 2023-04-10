/** Class: Case
 */
public class Case{
    private boolean contientUneBombe;
    private boolean estDecouverte;
    private boolean estMarquee;


    /** Cree une case qui ne contient pas de bombe, qui n'est pas decouverte et qui n'est pas marquee
     * Elle initialise les attributs contientUneBombe, estDecouverte et estMarquee
     */
    public Case() {
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarquee = false;
    }

    /** Méthode qui permet de remettre à zéro une case
     * Elle remet à zéro les attributs contientUneBombe, estDecouverte et estMarquee
     */
    public void reset(){
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarquee = false;
    }

    /** Méthode qui permet de poser une bombe sur une case
     * Elle modifie l'attribut contientUneBombe
     */
    public void poseBombe(){
        this.contientUneBombe = true;
    }

    /** Méthode qui permet de savoir si une case contient une bombe
    * @return true si la case contient une bombe, false sinon
    */
    public boolean contientUneBombe() {
        return contientUneBombe;
    }

    /** Méthode qui permet de savoir si une case est découverte
     * @return true si la case est découverte, false sinon
     */
    public boolean estDecouverte() {
        return estDecouverte;
    }

    /** Méthode qui permet de savoir si une case est marquée
    * @return true si la case est marquée, false sinon
    */
    public boolean estMarquee() {
        return estMarquee;
    }

    public void reveler() {
        this.estDecouverte = true;
    }

    /** Méthode qui permet de marquer/demarquer une case
     * Elle modifie l'attribut estMarquee
     */
    public void marquer() {
        if(!this.estMarquee){
            this.estMarquee = true;
        }else{
            this.estMarquee = false;
        }
    }
}
