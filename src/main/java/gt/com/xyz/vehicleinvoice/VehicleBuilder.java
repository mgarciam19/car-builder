package gt.com.xyz.vehicleinvoice;

import gt.com.xyz.vehicleinvoice.part.Part;
import java.util.*;

public class VehicleBuilder {

    private Map<String, Integer> items;
    private List<Part> parts;
    
    public VehicleBuilder() {
        this.items = new HashMap();
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

    private void reviewParts() {                
        for (Part part : this.parts) {  
            if (this.items.containsKey(part)) {
                this.items.put(part.getName(), this.items.get(part.getName()) + 1);           
            } else {
                this.items.put(part.getName(), 1);
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