import java.util.ArrayList;
import java.util.List;

/** Classe CaseIntelligente
 */
public class CaseIntelligente extends Case{
    private List<Case> lesVoisines;

    /** Instancie une liste de cases voisines
     */
    public CaseIntelligente(){
        this.lesVoisines = new ArrayList<>();
    }

    /** Ajoute une case voisine à la liste
     * @param uneCase Case à ajouter à la liste
     */
    public void ajouteVoisine(Case uneCase){
        this.lesVoisines.add(uneCase);
    }

    /** Permet de savoir combien de voisines contiennent une bombe3
     * @return int nombre de bombes voisines
     */
    public int nombreBombesVoisines(){
        int nbBombes = 0;
        for(Case voisin:this.lesVoisines){
            if(voisin.contientUneBombe()){
                nbBombes += 1;
            }
        }
        return nbBombes;
    }

    /** Permet de savoir que va afficher la case une fois découverte
     *@return String @ si la case contient une bombe, le nombre de bombes voisines et ? si la case est marquée
     * et un espace si la case n'est pas découverte
     */
    public String toString(){
        if(this.estDecouverte()){
            if(this.contientUneBombe()){
                return "@";
            }else{
                return ""+nombreBombesVoisines();
            }
        }else if(estMarquee()){
            return "?";
        }
        return " ";
    }
}
