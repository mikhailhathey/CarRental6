package com.CarRental.repositories.impl;

import com.CarRental.domain.Client;
import com.CarRental.factories.ClientFactory;
import com.CarRental.repositories.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientRepositoryImplTest {

    private ClientRepository repository;
    private Client client;

    private Client getSavedClient() {
        Set<Client> savedClients = this.repository.getAll();
        return savedClients.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ClientRepositoryImpl.getRepository();
        this.client = ClientFactory.buildClient("1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Street Road");
    }

    @Test
    public void a_create() {
        Client created = this.repository.create(this.client);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.client);
    }

    @Test
    public void b_read() {
       Client savedClient = getSavedClient();
        System.out.println("In read, clientId = "+ savedClient.getClientId());
        Client read = this.repository.read(savedClient.getClientId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedClient, read);
    }

    @Test
    public void e_delete() {
        Client savedClient = getSavedClient();
        this.repository.delete(savedClient.getClientId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Client Name";
        Client client = new Client.Builder().copy(getSavedClient()).clientName(newname).build();
        System.out.println("In update, about_to_updated = " + client);
        Client updated = this.repository.update(client);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getClientName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Client> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
