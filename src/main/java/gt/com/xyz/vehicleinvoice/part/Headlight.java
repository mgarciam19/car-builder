package gt.com.xyz.vehicleinvoice.part;

public class Headlight implements Part {

    public Headlight() {
    }
    
    private BulbType bulbType;

    public double getPrice() {        
        return 2000d;
    }

    public String getSupplier() {        
        return "Toyota";
    }

    public String getName() {
        return "Silvin";
    }

}