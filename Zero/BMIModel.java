package com.example.stephaniebaker_macpro.bmi_calculator;

import ca.roumani.i2c.Utility;

public class BMIModel
{
    private double weight;
    private double height;

    public BMIModel(String w, String h)
    {
        this.weight = Double.parseDouble(w);
        this.height = Double.parseDouble(h);
    }

    public String toPound()
    {
        String weightPound = String.format("%.0f", weight/0.454);
        return weightPound;
    }

    public String toFeetInch()
    {
        String heightFeet = Utility.m2FtInch(height);
        return heightFeet;

    }


    public String getBMI()
    {
        double index = this.weight/(this.height*this.height);
        String result = "Your weight is " + toPound() + ", your height is " + toFeetInch() + ", and your BMI is " + String.format("%.1f", index);
        return result;
    }

    public static void main(String[] args)
    {
        BMIModel myModel = new BMIModel("100", "1.8");
        System.out.println(myModel.getBMI());

        myModel = new BMIModel("45", "1.35");
        System.out.println(myModel.getBMI());

        myModel = new BMIModel("80", "1.2");
        System.out.println(myModel.getBMI());

        myModel = new BMIModel("77", "3.2");
        System.out.println(myModel.toPound());

        myModel = new BMIModel("77", "1.78");
        System.out.println(myModel.toFeetInch());
    }


}
