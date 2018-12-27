package P06_RawData;

public class Cargo {
    public String type;
    public int weight;

    public Cargo(String cargoType, int cargoWeight) {
        this.type = cargoType;
        this.weight = cargoWeight;
    }

    public String getType() {
        return type;
    }
}
