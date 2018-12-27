package wildFarm.food;

public abstract class Food {
    private int quantity;
    private String type;

    public Food(int quantity, String type) {
        this.setQuantity(quantity);
        this.setType(type);
    }

    public final int getQuantity() {
        return quantity;
    }

    private void setType(String type) {
        this.type = type;
    }

    public final String getType() {
        return type;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
