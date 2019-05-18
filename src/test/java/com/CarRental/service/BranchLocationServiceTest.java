package com.CarRental.service;

import com.CarRental.domain.BranchLocation;
import com.CarRental.factories.BranchLocationFactory;
import com.CarRental.repositories.impl.BranchLocationRepositoryImpl;
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
public class BranchLocationServiceTest {

    private BranchLocationRepositoryImpl repository;
    private BranchLocation branchLocation;


    @Before
    public void setUp() throws Exception {
        this.repository = BranchLocationRepositoryImpl.getRepository();
        this.branchLocation = BranchLocationFactory.buildBranchLocation("123", "TestBranch", "TestManager");
    }

    @Test
    public void getAll() {
        Set<BranchLocation> branchLocation = this.repository.getAll();
        System.out.println("In getall, all = " + branchLocation);
    }

}
