package com.company;

import com.company.classes.Options;
import com.company.classes.Producer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args) {
        //ArrayList<> bottlesPerDelivery;
        ArrayList<Producer> producerArrayList = new ArrayList<Producer>();
        System.out.print("Enter the amount of producers:");
        int producerAmount = sc.nextInt();
        for (int i = 0; i < producerAmount; i++) {
            producerArrayList.add(new Producer(i,1 + (rand.nextInt(49)),1 + (rand.nextInt(49))));
        }
        for (int i = 0; i < producerArrayList.size(); i++) {
            //System.out.println(producerArrayList.get(i).toString());
        }// DEBUG LOOP

        //ArrayList<Delivery> deliveryList;
        //ArrayList<Address> addressList; // (I need to add the initials of where the milk bottles were delivered)
        boolean loopStop = false;
        int choice=0;

        //System.out.flush();
        while(true){
            System.out.println("\n\n");
            System.out.println("----------*----------");
            System.out.println("1. Register a producer");
            System.out.println("2. Print the total of bottles delivered by a certain producer");
            System.out.println("3. Print who made the most deliveries");
            System.out.println("4. Print the average of deliveries");
            System.out.println("5. Above average deliveries made");
            System.out.println("6. Show the payments");
            System.out.println("7. Payment for a certain producer");
            System.out.println("8. Show total payment");
            System.out.println("9. Profit of the company");
            System.out.println("10. Exit");
            System.out.println("----------*----------");
            System.out.print("Enter a choice:");
            choice = sc.nextInt();
            System.out.println("\n");


            switch (choice){
                case 1:
                    System.out.println("Register A Producer:");
                    System.out.println("----------*----------");
                    Options.registerProducer(producerArrayList,sc);
                    break;
                case 2:
                    System.out.println("Amount Of Bottles Deliveries Made By A Producer:");
                    System.out.println("----------*----------");
                    System.out.print(Options.getAmountOfBottlesDelivered(producerArrayList,sc));;
                    break;
                case 3:
                    System.out.println("Most Deliveries Made:");
                    System.out.println("----------*----------");
                    System.out.println(Options.mostDeliveriesMade(producerArrayList));
                    break;
                case 4:
                    System.out.println("Average Deliveries Made:");
                    System.out.println("----------*----------");
                    double average = Options.averageDeliveriesMade(producerArrayList);
                    System.out.println("average = " + average);
                    break;
                case 5:
                    Options.aboveAverageDeliveriesMade(producerArrayList);
                    break;
                case 6:
                    System.out.println("Show The Payments:");
                    System.out.println("----------*----------");
                    System.out.println("Total Payments:"+ Options.paycheckTime(producerArrayList)+ "$");
                    break;
                case 7:
                    System.out.println("Payment For A Certain Producer:");
                    System.out.println("----------*----------");
                    System.out.println("Payment :" + Options.paymentForProducer(producerArrayList,sc) +"$");
                    break;
                case 8:
                    System.out.println("Show The Total Payment:");
                    System.out.println("----------*----------");
                    System.out.println("Total Payment:" + Options.paycheckTime2(producerArrayList) +"$");
                    break;
                case 9:
                    System.out.println("Profit Of The Company:");
                    System.out.println("----------*----------");
                    System.out.println("Profit :" + Options.calculateProfit(producerArrayList) +"$");
                    break;
                case 10:
                    sc.close();
                    System.exit(1);
                    break;
            }
        }

    }
}
