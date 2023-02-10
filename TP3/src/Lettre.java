import java.util.Arrays;
import java.util.List;

public class Lettre{
    
    private char lettre;
    private static List<String> alphabetMorse = Arrays.asList("=_===", 
            "===_=_=_=", "===_===_=", "===_=_=", "=", "=_=_===_=",
            "===_===_=", "=_=_=_=", "=_=", "=_===_===_===", "===_=_===",
            "=_===_=_=", "===_===", "===_=", "===_===_===", "=_===_===_=",
            "===_===_=_===", "=_===_=", "=_=_=", "===", "=_=_===",
            "=_=_=_===", "=_===_===", "===_=_=_===", "===_=_===_===",
            "===_===_=_=", "_");

    public Lettre(char lettre){
        this.lettre = lettre;
    }

    public Lettre(String morse){
        if(morse.equals("_")){
            this.lettre = ' ';
        }
        for(int i=0;i<Lettre.alphabetMorse.size();i++){
            if(Lettre.alphabetMorse.get(i).equals(morse)){
                this.lettre = (char) (i + 65);
            }
        }
    }

    public int toNumero(){
        if (this.lettre == ' '){
            return 26;
        }
        return (int) this.lettre - 65; 
    }

    public char toChar(){
        return this.lettre;
    }

    public String toMorse(){
        return alphabetMorse.get(toNumero());
    }

    @Override
    public String toString(){
        return ""+this.lettre;
    }

}
