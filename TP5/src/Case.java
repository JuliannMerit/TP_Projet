public class Case {
    private boolean contientBombe;
    private boolean estDecouverte;

    public Case() {
        this.contientBombe = false;
        this.estDecouverte = false;
    }

    public boolean contientUneBombe() {
        return contientBombe;
    }

    public boolean estDecouvert() {
        return estDecouverte;
    }

    public void decouvrir() {
        estDecouverte = true;
    }

}
