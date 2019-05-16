package com.CarRental.service.impl;

import com.CarRental.domain.Claims;
import com.CarRental.factories.ClaimsFactory;
import com.CarRental.repositories.impl.ClaimsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClaimsServiceImplTest {

    private ClaimsRepositoryImpl repository;
    private Claims claims;

    private Claims getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ClaimsRepositoryImpl.getRepository();
        this.claims = ClaimsFactory.buildClaims("1234", "Discovery", "12000", "Stolen");
    }

    @Test
    public void a_create() {
        Claims created = this.repository.create(this.claims);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.claims);
    }

    @Test
    public void c_update() {
        String newClaimsName = "Application Development Theory 3";
        Claims updated = new Claims.Builder().copy(getSaved()).claimsId(newClaimsName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newClaimsName, updated.getClaimsId());
    }

    @Test
    public void e_delete() {
        Claims saved = getSaved();
        this.repository.delete(saved.getClaimsId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Claims saved = getSaved();
        Claims read = this.repository.read(saved.getClaimsId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Claims> claimss = this.repository.getAll();
        System.out.println("In getall, all = " + claimss);
    }
}
