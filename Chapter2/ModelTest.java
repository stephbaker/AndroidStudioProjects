package com.example.stephaniebaker_macpro.chapter2;

import org.junit.Assert;
import org.junit.Test;

public class ModelTest {
@Test
    public void testPayment()
    {
        MortgageModel myModel;

        myModel = new MortgageModel("700000", "25", "2.75");
        Assert.assertEquals("C1", "$3,229.18", myModel.computePayment());
    }

}
