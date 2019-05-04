package com.CarRental.factories;

import com.CarRental.domain.Assets;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AssetsFactoryTest extends TestCase {

    public void testBuildAssets() {
    }

    private String AssetsTest;

    @Before
    public void setUp() throws Exception {
        this.AssetsTest = "AssetsTest";
    }

    @Test
    public void buildAssets() {
        Assets assets = AssetsFactory.buildAssets("123", "DSLR Camera", "Cupboard", "Camera");
        System.out.println(assets);
        Assert.assertNotNull(assets.getAssetsId());
    }
}