package gt.com.xyz.vehicleinvoice.part;

public class Seat implements Part {

    public Seat() {
    }
    
    private SeatMaterial material;

    private boolean heated;

    public double getPrice() {        
        return 6000d;
    }

    public String getSupplier() {        
        return "Toyota";
    }

    public String getName() {
        return "Asiento";
    }

}