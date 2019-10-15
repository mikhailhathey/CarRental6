package com.CarRental.factories;

        import com.CarRental.domain.Region;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class RegionFactoryTest {

    public void testBuildRegion(){

    }

    private String RegionTest;

    @Before
    public void setUp() throws Exception {
        this.RegionTest = "RegionTest";
    }

    @Test
    public void buildRegion() {
        Region region = RegionFactory.buildRegion(765, "Hatfield", "Pretoria");
        System.out.println(region);
        Assert.assertNotNull(region.getRegionId());
    }
}
