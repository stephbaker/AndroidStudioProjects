package com.example.stephaniebaker_macpro.chapter2;

public class MortgageModel {

    private double principle;
    private double interest;
    private int amortization;

    public MortgageModel(String p, String a, String i)
    {
        this.principle = Double.parseDouble(p);
        this.interest = Double.parseDouble(i);
        this.amortization = Integer.parseInt(a);
    }

    public String computePayment()
    {
        double r = this.interest/1200;
        int n = this.amortization*12;
        double index = (r*this.principle)/(1 - Math.pow((1+r), -n));
        String result = "$" + String.format("%,.2f", index);
        return result;
    }

    public static void main(String[] args)
    {
        MortgageModel myModel = new MortgageModel("700000", "25", "2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("300000", "20", "4.50");
        System.out.println(myModel.computePayment());
    }

}
