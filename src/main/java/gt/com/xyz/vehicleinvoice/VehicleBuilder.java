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

    public void build() throws Exception {

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
        int Impuestos = 0;
        int totalfact = 0;
        double tax = 1.12 / 100;

        System.out.println("######################################################################################################");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Cantidad    PU         Sub-Total         Descripción");
        System.out.println("-----------------------------------------------------------");
        for (Part part : this.parts) {
            int cantidad = partsCount.get(part.getName());
            double precio = part.getPrice();
            String Parte = part.getName();
            double SubPrecio = precio * cantidad;
            
            if (cantidad >= 1) {
                System.out.println(String.format("%d           Q.%s       Q.%s \t\t%s",cantidad, precio, SubPrecio ,Parte));
                partsCount.put(part.getName(),0);
            }
            
            
            total += part.getPrice();
            Impuestos = (int) (total * tax);
            totalfact = total + Impuestos;
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println(String.format("Total sin Impuestos\tQ.%d", total));
        System.out.println(String.format("Impuestos\t\tQ.%2d", Impuestos));
        System.out.println("-----------------------------------------------------------");
        System.out.println(String.format("Total mas Impuestos\tQ.%d", totalfact));
        System.out.println("-----------------------------------------------------------");
        System.out.println("######################################################################################################");
    }

}
