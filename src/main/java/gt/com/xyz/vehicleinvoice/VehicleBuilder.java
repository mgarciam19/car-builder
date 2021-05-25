package gt.com.xyz.vehicleinvoice;

import gt.com.xyz.vehicleinvoice.part.Engine;
import gt.com.xyz.vehicleinvoice.part.GearBox;
import gt.com.xyz.vehicleinvoice.part.Headlight;
import gt.com.xyz.vehicleinvoice.part.Part;
import gt.com.xyz.vehicleinvoice.part.Seat;
import gt.com.xyz.vehicleinvoice.part.Tire;
import gt.com.xyz.vehicleinvoice.part.Wheel;
import java.util.*;

public class VehicleBuilder {
    
    public static final int MAX_ENGINE = 1;
    public static final int MAX_GEAR_BOX = 1;
    public static final int MAX_WHEEL = 4;
    public static final int MAX_TIRE = 4;
    public static final int MAX_SEAT = 5;
    public static final int MAX_HEADLIGHT = 2;    

    private Map<String, Integer> partsCount;
    
    private List<Part> parts;
    
    public VehicleBuilder() {
        this.partsCount = new HashMap();
        this.parts = new LinkedList();
    }   

    public VehicleBuilder addPart(Part part) {
        this.parts.add(part);
        
        return this;
    }
    
    public void build() {
        this.reviewParts();
        
        this.buildInvoice();
    }

    private void reviewParts() throws Exception {                
        for (Part part : this.parts) {            
            if (this.partsCount.containsKey(part.getName())) {
                int maxAllowedParts = 1;
                
                if (part instanceof Engine) {
                    maxAllowedParts = MAX_ENGINE;
                } else if (part instanceof GearBox) {
                    maxAllowedParts = MAX_GEAR_BOX;
                } else if (part instanceof Wheel) {
                    maxAllowedParts = MAX_WHEEL;
                } else if (part instanceof Tire) {
                    maxAllowedParts = MAX_TIRE;
                } else if (part instanceof Seat) {
                    maxAllowedParts = MAX_SEAT;
                } else if (part instanceof Headlight) {
                    maxAllowedParts = MAX_HEADLIGHT;
                }
                
                if (this.partsCount.get(part.getName()) >= maxAllowedParts) {
                    throw new Exception(String.format("Se ha excedido la cantidad máxima de partes de tipo %s", part.getName()));
                }
                
                this.partsCount.put(part.getName(), this.partsCount.get(part.getName()) + 1);           
            } else {
                this.partsCount.put(part.getName(), 1);
            }
        }        
    }
    
    private void buildInvoice() {
        int total = 0;
                
        System.out.println("######################################################################################################");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Cantidad    PU          Descripción");
        System.out.println("-----------------------------------------------------------");
        for (Part part : this.parts) {              
            System.out.println(String.format("1           15.00\t%s", part.getName()));
            total += part.getPrice();
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println(String.format("Total\t\t\t\t%d", total));
        System.out.println("-----------------------------------------------------------");
        System.out.println("######################################################################################################");
    }

}