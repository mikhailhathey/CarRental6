package com.CarRental.service.impl;

import com.CarRental.domain.Client;
import com.CarRental.factories.ClientFactory;
import com.CarRental.repositories.impl.ClientRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceImplTest {

    private ClientRepositoryImpl repository;
    private Client client;

    private Client getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.client);
    }

    @Test
    public void c_update() {
        String newClientName = "Application Development Theory 3";
        Client updated = new Client.Builder().copy(getSaved()).clientId(newClientName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newClientName, updated.getClientId());
    }

    @Test
    public void e_delete() {
        Client saved = getSaved();
        this.repository.delete(saved.getClientId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Client saved = getSaved();
        Client read = this.repository.read(saved.getClientId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Client> clients = this.repository.getAll();
        System.out.println("In getall, all = " + clients);
    }
}
