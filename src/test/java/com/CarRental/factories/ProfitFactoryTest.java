package com.CarRental.factories;

        import com.CarRental.domain.Profit;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class ProfitFactoryTest {

    public void testBuildProfit(){

    }

    private String ProfitTest;

    @Before
    public void setUp() throws Exception {
        this.ProfitTest = "ProfitTest";
    }

    @Test
    public void buildProfit() {
        Profit profit = ProfitFactory.buildProfit("789", "100000", "120000");
        System.out.println(profit);
        Assert.assertNotNull(profit.getProfitId());
    }
}