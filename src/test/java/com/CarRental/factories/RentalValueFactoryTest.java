package com.CarRental.factories;

        import com.CarRental.domain.RentalValue;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class RentalValueFactoryTest {

    public void testBuildRentalValue(){

    }

    private String RentalValueTest;

    @Before
    public void setUp() throws Exception {
        this.RentalValueTest = "RentalValueTest";
    }

    @Test
    public void buildRentalValue() {
        RentalValue region = RentalValueFactory.buildRentalValue(902, "Bus", "4000");
        System.out.println(region);
        Assert.assertNotNull(region.getRentalValueId());
    }
}
