package com.company.classes;

import java.util.Collection;

public class Producer {
    public double paymentPerBottle = 0.5; // dollars
    public int id;
    public int deliveries;
    public int bottlesPerDelivery;
    public double salary;
    public Producer(int id,int deliveries,int bottlesPerDelivery){
        this.id=id;
        this.deliveries = deliveries;
        this.bottlesPerDelivery = bottlesPerDelivery;
    }

    @Override
    public String toString() {
        return "ID:" + this.id +"\n" +
                "Deliveries:" + this.deliveries + "\n" +
                "Bottles per delivery:" + this.bottlesPerDelivery + "\n" + "Payment:" + this.deliveries*
                this.bottlesPerDelivery* paymentPerBottle + "$\n";
    }
    //Overriding toString method so we get those outputs like that.
}
