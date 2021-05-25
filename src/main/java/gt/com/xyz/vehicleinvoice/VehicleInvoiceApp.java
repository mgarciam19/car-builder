package gt.com.xyz.vehicleinvoice;

import gt.com.xyz.vehicleinvoice.part.Engine;
import gt.com.xyz.vehicleinvoice.part.GearBox;
import gt.com.xyz.vehicleinvoice.part.Headlight;
import gt.com.xyz.vehicleinvoice.part.Seat;
import gt.com.xyz.vehicleinvoice.part.Tire;
import gt.com.xyz.vehicleinvoice.part.Wheel;

public class VehicleInvoiceApp {

    public VehicleInvoiceApp() {
    }

    public static void main(String[] args) {
        VehicleBuilder builder = new VehicleBuilder();
        
        builder
                .addPart(new Engine())
                .addPart(new GearBox())
                .addPart(new Headlight())
                .addPart(new Headlight())
                .addPart(new Wheel())
                .addPart(new Wheel())
                .addPart(new Wheel())
                .addPart(new Wheel())
                .addPart(new Tire())
                .addPart(new Tire())
                .addPart(new Tire())
                .addPart(new Tire())
                .addPart(new Seat())
                .addPart(new Seat())
                .addPart(new Seat())
                .addPart(new Seat())
                .addPart(new Seat())
                .build();
    }

}