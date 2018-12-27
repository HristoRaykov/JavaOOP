package p11_CatLady.cat;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, String breed, Double earSize) {
        super(name, breed);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", this.earSize);
    }
}
