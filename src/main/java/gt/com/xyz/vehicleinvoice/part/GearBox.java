package gt.com.xyz.vehicleinvoice.part;

public class GearBox implements Part {

    public GearBox() {
    }
    
    private String id = "GEARBOX";

    private GearBoxType type;

    private int speedNum;

    private TransmissionType transmission;

    public double getPrice() {        
        return 6000d;
    }

    public String getSupplier() {
        // TODO implement here
        return "Toyota";
    }

    public String getName() {
        return "Transmisión";
    }

}