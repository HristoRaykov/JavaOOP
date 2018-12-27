package mordor;

public class Gandalf {
    private int happiness;

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
            this.happiness += happiness;
    }

    public void calculateHappiness(String food) {
        switch (food.toLowerCase()) {
            case "cram":
                setHappiness(2);
                break;
            case "lembas":
                setHappiness(3);
                break;
            case "apple":
                setHappiness(1);
                break;
            case "melon":
                setHappiness(1);
                break;
            case "honeycake":
                setHappiness(5);
                break;
            case "mushrooms":
                setHappiness(-10);
                break;
            default:
                setHappiness(-1);
                break;
        }
    }
}
