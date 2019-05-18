package com.CarRental.service;

import com.CarRental.domain.Client;
import com.CarRental.factories.ClientFactory;
import com.CarRental.repositories.impl.ClientRepositoryImpl;
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
public class ClientServiceTest {

    private ClientRepositoryImpl repository;
    private Client client;


    @Before
    public void setUp() throws Exception {
        this.repository = ClientRepositoryImpl.getRepository();
        this.client = ClientFactory.buildClient("1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Street Road");
    }

    @Test
    public void getAll() {
        Set<Client> client = this.repository.getAll();
        System.out.println("In getall, all = " + client);
    }

}
