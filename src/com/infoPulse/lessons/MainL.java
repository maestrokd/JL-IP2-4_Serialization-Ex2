package com.infoPulse.lessons;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class MainL {

    
    public static void main(String[] args) {
        ArrayList<Payment> payments = new ArrayList<>();

        System.out.println(payments.size());


        // Deserealization ata of Payments from file "payment.ser"
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("payment.ser"));)
        {
            payments = (ArrayList<Payment>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(payments.size());


        // Add data in new field
        int i = 0;
        int count = 0;
        Random r = new Random();

        for (Payment payment : payments){
//            payment.setCheckNumber(++i);
            StringBuilder randString = new StringBuilder();
            count = r.nextInt(6)+5;
            for (int j = 0; j < count; j++){
                randString.append((char)(r.nextInt(26 )+ 'a'));
            }
            payment.setCheckNumber(String.valueOf(randString));
        }




        char c = (char)(r.nextInt(26) + 'a');


        // Write data of Payments in file "payments_output.txt"
        writeInFile(payments);
    }

    public static void writeInFile(ArrayList<Payment> payments){
        try (PrintWriter out = new PrintWriter(String.valueOf("payments_output.txt")))
        {
            for (Payment payment : payments){
                out.println(payment.getCustomerNumber() + "|" + payment.getPaymentDate() + "|" + payment.getAmount() + "|"
                        + payment.getCheckNumber());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        }
    }
}
