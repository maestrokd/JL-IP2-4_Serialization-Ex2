package com.infoPulse.lessons;

import java.io.Serializable;

public class Payment implements Serializable{
    private static final long serialVersionUID = 1;
    private String customerNumber;
    private String paymentDate;
    private String amount;
    private String checkNumber;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public Payment(String customerNumber, String paymentDate, String amount, String checkNumber) {
        this.customerNumber = customerNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.checkNumber = checkNumber;
    }


}


