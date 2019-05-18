package com.CarRental.service;

import com.CarRental.domain.Assets;
import com.CarRental.factories.AssetsFactory;
import com.CarRental.repositories.impl.AssetsRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)
public class AssetsServiceTest {

    private AssetsRepositoryImpl repository;
    private Assets assets;


    @Before
    public void setUp() throws Exception {
        this.repository = AssetsRepositoryImpl.getRepository();
        this.assets = AssetsFactory.buildAssets("123", "DSLR Camera", "Cupboard", "Camera");
    }

    @Test
    public void getAll() {
        Set<Assets> assets = this.repository.getAll();
        System.out.println("In getall, all = " + assets);
    }

}
