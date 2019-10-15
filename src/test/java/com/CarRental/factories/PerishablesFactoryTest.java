package com.CarRental.factories;

import com.CarRental.domain.Perishables;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerishablesFactoryTest {

    public void testBuildPerishables(){

    }

    private String PerishablesTest;

    @Before
    public void setUp() throws Exception {
        this.PerishablesTest = "PerishablesTest";
    }

    @Test
    public void buildPerishables() {
        Perishables perishables = PerishablesFactory.buildPerishables(567, "Bread", "12/05/2019", "5");
        System.out.println(perishables);
        Assert.assertNotNull(perishables.getPerishablesId());
    }
}