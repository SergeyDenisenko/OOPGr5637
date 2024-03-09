package Domen;

public class HotDrink extends Product {
    private int temperature;

    public HotDrink(int temperature) {
        this.temperature = temperature;
    }

    public HotDrink(int price, int temperature) {
        super(price);
        this.temperature = temperature;
    }

    public HotDrink(int price, int place, int temperature) {
        super(price, place);
        this.temperature = temperature;
    }

    public HotDrink(int price, int place, String name, int temperature) {
        super(price, place, name);
        this.temperature = temperature;
    }

    public HotDrink(int price, int place, String name, long id, int temperature) {
        super(price, place, name, id);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntemperature=" + temperature;
    }
}
