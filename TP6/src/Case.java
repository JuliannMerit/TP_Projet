public class Case{
    private boolean contientUneBombe;
    private boolean estDecouverte;
    private boolean estMarquee;

    public Case() {
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarquee = false;
    }

    public void reset(){
        this.contientUneBombe = false;
        this.estDecouverte = false;
        this.estMarquee = false;
    }

    public void poseBombe(){
        this.contientUneBombe = true;
    }

    public boolean contientUneBombe() {
        return contientUneBombe;
    }

    public boolean estDecouverte() {
        return estDecouverte;
    }

    public boolean estMarquee() {
        return estMarquee;
    }

    public void reveler() {
        this.estDecouverte = true;
    }

    public void marquer() {
        this.estMarquee = true;
    }
}
