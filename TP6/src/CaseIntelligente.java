import java.util.ArrayList;
import java.util.List;

public class CaseIntelligente extends Case{
    private List<Case> lesVoisines;
    
    public CaseIntelligente(){
        this.lesVoisines = new ArrayList<>();
    }

    public void ajouteVoisine(Case uneCase){
        this.lesVoisines.add(uneCase);
    }

    public int nombreBombesVoisines(){
        int nbBombes = 0;
        for(Case voisin:this.lesVoisines){
            if(voisin.contientUneBombe()){
                nbBombes += 1;
            }
        }
        return nbBombes;
    }

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
