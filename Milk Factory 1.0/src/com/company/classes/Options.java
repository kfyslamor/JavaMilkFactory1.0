package com.company.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Options {
    final static double bottleSellPrice = 2.5; // dollars
    final static double paymentPerBottle = 0.5; // dollars
    final static double extraPrize = 150; // dollars
    final static double bottleCost = 0; // dollars

    //1
    public static void registerProducer(ArrayList<Producer> producerArrayList, Scanner sc){
        System.out.print("Assigned ID:");
        int producerReg1 = producerArrayList.get(producerArrayList.size()-1).id+2,producerReg2,producerReg3;

        System.out.println(producerReg1);
        System.out.print("Enter Delivery:");
        producerReg2 = sc.nextInt();
        while (producerReg2< 0 || producerReg2 > 51){
            System.out.println("ERROR : Delivery can't be lower than 0 or higher than 50!");
            System.out.print("Enter Delivery:");
            producerReg2 = sc.nextInt();
        }
        System.out.print("Enter bottles per delivery:");
        producerReg3 = sc.nextInt();
        while (producerReg3< 0 || producerReg3> 51){
            System.out.println("ERROR : Amount of bottles delivered can't be lower than 0 or higher than 50");
            System.out.print("Enter bottles per delivery:");
            producerReg3 = sc.nextInt();
        }

        producerArrayList.add(new Producer(producerReg1,producerReg2,producerReg3));

        System.out.println("**PRODUCER REGISTERED**");
    }
    //2
    public static int getAmountOfBottlesDelivered(ArrayList<Producer> producerArrayList,Scanner sc){
        System.out.print("Enter producer's ID:");
        int producerID = sc.nextInt();
        while(producerID > producerArrayList.size() || producerID < 0){
            System.out.println("ERROR : The amount of registered producers are :" + producerArrayList.size());
            producerID = sc.nextInt();
        }
        Producer producer1 = producerArrayList.get(producerID);
        System.out.println(producer1.toString());
        System.out.println("total of bottles delivered by the producer "+ producer1.id + ":");
        return producer1.bottlesPerDelivery*producer1.deliveries;
    }
    //3
    public static Producer mostDeliveriesMade(ArrayList<Producer> producerArrayList) {
        System.out.println("Producer with the most deliveries:");
        int max=0;
        Producer producerWithMaxDeliveries = new Producer(0,0,0);
        for (Producer producer : producerArrayList) {
            if (producer.deliveries > max) {
                max = producer.deliveries;
                producerWithMaxDeliveries = producer;
            }
        }
        //System.out.print(producerWithMaxDeliveries.toString());
        return producerWithMaxDeliveries;
    }
    //4
    public static double averageDeliveriesMade(ArrayList<Producer> producerArrayList) {
        int total = 0;
        double average;
        for (Producer producer : producerArrayList) {
            total += producer.deliveries;
        }
        average = (double)total / producerArrayList.size();
        //System.out.println("average = " + average);
        return average;
    }
    //5
    public static void aboveAverageDeliveriesMade(ArrayList<Producer> producerArrayList) {
        System.out.println("Above average deliveries made:");
        double average = averageDeliveriesMade(producerArrayList);
        System.out.println("average = " + average);
        for (Producer producer : producerArrayList) {
            if (producer.deliveries > average) {
                System.out.println(producer.toString());
            }
        }

    }
    //6
    public static double paycheckTime(ArrayList<Producer> producerArrayList) {
        int paycheckTotal=0;
        for (int i = 0; i < producerArrayList.size(); i++) {
            paycheckTotal += producerArrayList.get(i).deliveries * producerArrayList.get(i).bottlesPerDelivery * (paymentPerBottle- bottleCost);
            if (mostDeliveriesMade(producerArrayList).id == producerArrayList.get(i).id){
                System.out.println("ID:" + producerArrayList.get(i).id +"\n" +
                        "Deliveries:" + producerArrayList.get(i).deliveries + "\n" +
                        "Bottles per delivery:" + producerArrayList.get(i).bottlesPerDelivery + "\n" + "Payment + EXTRA:" + (((producerArrayList.get(i).deliveries*
                        producerArrayList.get(i).bottlesPerDelivery* paymentPerBottle)) + extraPrize) + "$\n");
            }
            else{
                System.out.println(producerArrayList.get(i).toString());
            }

            // deliveries * bottles per delivery, amount of total bottles delivered.
            // multiply by paymentPerBottle gives the total amount that is going to be paid EXCLUDING THE BONUS.
        }
        return paycheckTotal + extraPrize;
    }
    //7
    public static double paymentForProducer(ArrayList<Producer> producerArrayList, Scanner sc) {
        System.out.print("Enter ID:");
        int producerID = sc.nextInt();
        while(producerID > producerArrayList.size() || producerID < 0){
            System.out.println("ERROR : The amount of registered producers are :" + producerArrayList.size());
            producerID = sc.nextInt();
        }
        System.out.println(producerArrayList.get(producerID).toString());
        return producerArrayList.get(producerID).deliveries * producerArrayList.get(producerID).bottlesPerDelivery * (paymentPerBottle- bottleCost);
    }
    //8
    public static double paycheckTime2(ArrayList<Producer> producerArrayList) {
        int paycheckTotal=0;
        for (Producer producer : producerArrayList) {
            paycheckTotal += producer.deliveries * producer.bottlesPerDelivery * (paymentPerBottle - bottleCost);
            // deliveries * bottles per delivery, amount of total bottles delivered.
            // multiply by paymentPerBottle gives the total amount that is going to be paid EXCLUDING THE BONUS.
        }
        return paycheckTotal + extraPrize;
    }
    //9
    public static double calculateProfit(ArrayList<Producer> producerArrayList) {

        double profit=0;
        for (Producer producer : producerArrayList) {
            profit += (producer.deliveries * producer.bottlesPerDelivery) * (bottleSellPrice - paymentPerBottle - bottleCost);
            // total bottles delivered multiplied by PROFIT from each bottle.
        }
        profit -= extraPrize; // extra prize wasn't calculated in the loop.
        return profit;
    }
}
/*while(producerReg1 <= producerArrayList.size() && producerReg1 >= 0){
            System.out.println("ERROR : ID can't be equal or smaller than the amount of already registered " +
                    "producers.\n" +
                    "Amount of producers : " + producerArrayList.size());
            producerReg1 = sc.nextInt();
        }*/