public class Case {
    private boolean contientBombe;
    private boolean estDecouverte;
    private boolean estMarqueur;

    public Case() {
        this.contientBombe = false;
        this.estDecouverte = false;
        this.estMarqueur = false;
    }

    public boolean contientUneBombe() {
        return contientBombe;
    }

    public boolean estDecouvert() {
        return estDecouverte;
    }

    public boolean estMarque() {
        return estMarqueur;
    }

    public void decouvrir() {
        this.estDecouverte = true;
    }

    public void marquer() {
        this.estMarqueur = true;
    }

    public void setBombe() {
        this.contientBombe = true;
    }

}
