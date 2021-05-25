package gt.com.xyz.vehicleinvoice.part;

public class Wheel implements Part {

    public Wheel() {        
    }
    
    private String color;

    private WheelMaterial material;

    private int size;

    public double getPrice() {        
        return 2000d;
    }    

    public String getSupplier() {        
        return "AD";
    }
    
    public String getName() {
        return "Aro";
    }
    
}