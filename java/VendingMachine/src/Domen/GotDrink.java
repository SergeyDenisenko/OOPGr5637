package Domen;

public class GotDrink extends Product {
    private int temperature;

    public GotDrink(int temperature) {
        this.temperature = temperature;
    }

    public GotDrink(int price, int temperature) {
        super(price);
        this.temperature = temperature;
    }

    public GotDrink(int price, int place, int temperature) {
        super(price, place);
        this.temperature = temperature;
    }

    public GotDrink(int price, int place, String name, int temperature) {
        super(price, place, name);
        this.temperature = temperature;
    }

    public GotDrink(int price, int place, String name, long id, int temperature) {
        super(price, place, name, id);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
