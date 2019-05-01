package com.CarRental.factories;

        import com.CarRental.domain.RentalTerm;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class RentalTermFactoryTest {

    public void testBuildRentalTerm(){

    }

    private String RentalTermTest;

    @Before
    public void setUp() throws Exception {
        this.RentalTermTest = "RentalTermTest";
    }

    @Test
    public void buildRentalTerm() {
        RentalTerm rentalTerm = RentalTermFactory.buildRentalTerm("324", "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD");
        System.out.println(rentalTerm);
        Assert.assertNotNull(rentalTerm.getRentalTermId());
    }
}
