package p11_CatLady.cat;

public class StreetExtraordinaire extends Cat {
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, String breed, double decibelsOfMeows) {
        super(name, breed);
        this.decibelsOfMeows = decibelsOfMeows;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", this.decibelsOfMeows);
    }
}
