package gt.com.xyz.vehicleinvoice.part;

public class Tire implements Part {

    public Tire() {
    }
    
    private int size;

    private TireType type;

    public double getPrice() {
        return 800d;
    }

    public String getSupplier() {        
        return "Bridgestone";
    }
    
    public String getName() {
        return "Neumático";
    }
    
    

}