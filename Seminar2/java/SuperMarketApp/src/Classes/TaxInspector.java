package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;

public class TaxInspector implements iActorBehaviour, iReturnOrder {
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
    

    public TaxInspector() {
        this.name = "Tax Audit";
    }

    public String getName()
    {
        return name;
    }

  
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public boolean isMakeOrder() {
        return isMakeOrder; 
    }

    public void setTakeOrder(boolean val) {
        isTakeOrder = val;
    }
    public void setMakeOrder(boolean val) {
        isMakeOrder = val;        
    }

    @Override
    public Actor geActor() {
        return new OrdinaryClient(name);
    }
    
    public boolean returnOrder() {
        if (this.isTakeOrder()) {
            this.setTakeOrder(false);
            return true;
        }
        return false;
    }
}
