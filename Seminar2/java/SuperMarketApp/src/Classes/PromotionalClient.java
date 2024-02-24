package Classes;

public class PromotionalClient extends Actor {
    private int id;                     // идентификатор клиента
    private static int count;           // счетчик
    private static int numberOfSeats;   // количество мест в акции
    private String namePromotion;       // название акции

    public PromotionalClient(String name, String promotion, int quantity) {
        super(name);
        this.count++;
        this.id = this.count;
        if (this.id > quantity) {
            promotion = "None";
        }
        this.namePromotion = promotion;
        this.numberOfSeats = quantity;
    }

    /**
     * @return name
     */
    public String getName() {
        return super.name;
    }

    /**
     * @param name Имя клиента
     */
    @Override
    public void setName(String name) {
        super.name = name;
    }

    /**
     * 
     * @return идентификатор клиента
     */
    public int getId() {
        return id;
    }

    /**
     * @return статус получения заказа
     */
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    /**
     * @return статус создания заказа
     */
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    /**
     * @apiNote Устанавливает статус получения заказа
     * @param val
     */
    public void setTakeOrder(boolean val) {
        if (this.id <= this.count) {
            super.isTakeOrder = val;
        }
    }

    /**
     * @return Actor
     */
    public Actor geActor() {
        return this;
    }

    /**
     * @apiNote Возвращает товар
     * @return Статус возврата товара
     */
    public boolean returnOrder() {
        if (this.isTakeOrder()) {
            this.setTakeOrder(false);
            return true;
        }
        return false;
    }

    /**
     * @apiNote Устанавливает статус создания заказа
     * @param val
     */
    public void setMakeOrder(boolean val) {
        super.isMakeOrder = val;
    }

    /**
     * @apiNote Возвращает количество участников в акции
     * @return количество участников в акции
     */
    public static int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * @apiNote Устанавливает количество участников в акции
     * @param numberOfSeats количество участников в акции
     */
    public static void setNumberOfSeats(int numberOfSeats) {
        PromotionalClient.numberOfSeats = numberOfSeats;
    }
}
