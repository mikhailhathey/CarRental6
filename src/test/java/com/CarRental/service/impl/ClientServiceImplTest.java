package com.CarRental.service.impl;

import com.CarRental.domain.Client;
import com.CarRental.factories.ClientFactory;
import com.CarRental.service.ClientService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientServiceImplTest {
  @Autowired
  @Qualifier("ClientServiceImpl")
  private ClientService clientService;
  private Client client;
  private Set<Client> clients = new HashSet<>();

  @Before
  public void setUp() {
      client = clientService.create(ClientFactory.buildClient("1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Client Road"));
      clients.add(client);
  }

  @Test
  public void create() {
      Client createClient = clientService.create(ClientFactory.buildClient(
              "1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Client Road"));
      clients.add(createClient);
      Assert.assertEquals(createClient, clientService.read(createClient.getClientId()));
  }

  @Test
  public void read() {
      Client readTestClient = clientService.create(ClientFactory.buildClient(
              "1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Client Road"));
      Assert.assertEquals(readTestClient, clientService.read(readTestClient.getClientId()));
  }

  @Test
  public void update() {
      String newClientName = "Test";
      Client updateClient = clientService.update(new Client.Builder().copy(client).clientName(newClientName).build());
      clients.add(updateClient);
      Assert.assertEquals(updateClient, clientService.read(updateClient.getClientId()));
  }

  @Test
  public void delete() {
      clients.addAll(clientService.getAll());
      Client deleteClient = clientService.create(ClientFactory.buildClient("1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Client Road"));
      clients.add(deleteClient);
      clients.remove(deleteClient);
      clientService.delete(deleteClient.getClientId());
      Assert.assertEquals(clients.size(), clientService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Client> clientSet = clientService.getAll();
      Assert.assertEquals(clientSet.size(), clientService.getAll().size());
  }
}
//"1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Client Road"
