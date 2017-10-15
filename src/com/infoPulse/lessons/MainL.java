package com.infoPulse.lessons;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MainL {

    public static void main(String[] args) {
        ArrayList<Payment> payments = new ArrayList<>();


        // Deserialization data of Payments from file "payment.ser"
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("payment.ser")))
        {
            payments = (ArrayList<Payment>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound (payment.ser)");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Add data in new field
        int count;
        Random r = new Random();

        for (Payment payment : payments){
            StringBuilder randString = new StringBuilder();
            count = r.nextInt(6)+5;
            for (int j = 0; j < count; j++){
                randString.append((char)(r.nextInt(26 )+ 'a'));
            }
            payment.setCheckNumber(String.valueOf(randString));
        }


        // Write data of Payments in file "payments_output.txt"
        writeInFile(payments);
    }

    private static void writeInFile(ArrayList<Payment> payments){
        try (PrintWriter out = new PrintWriter(String.valueOf("payments_output.txt")))
        {
            for (Payment payment : payments){
                out.println(payment.getCustomerNumber() + "|" + payment.getPaymentDate() + "|"
                        + payment.getAmount() + "|" + payment.getCheckNumber());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound (payments_output.txt)");
        }
    }
}
