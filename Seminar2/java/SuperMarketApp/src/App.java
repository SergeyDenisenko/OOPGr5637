import Classes.Actor;
import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromotionalClient;
import Classes.SpecialClient;
import Classes.TaxInspector;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {
        Market magnit = new Market();

        iActorBehaviour client1 = new OrdinaryClient("boris");
        iActorBehaviour client2 = new OrdinaryClient("masha");
        iActorBehaviour client3 = new SpecialClient("prezident", 1);
        iActorBehaviour client4 = new TaxInspector();
        iActorBehaviour client5 = new PromotionalClient("Ivan", "Stock", 5);
        iActorBehaviour client6 = new PromotionalClient("Olga", "Stock", 5);


        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        magnit.acceptToMarket(client5);
        magnit.acceptToMarket(client6);

        magnit.update();

        System.out.println("--------------");

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        magnit.acceptToMarket(client5);
        magnit.acceptToMarket(client6);
    }
}
