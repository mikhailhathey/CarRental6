package com.CarRental.repositories.impl;

import com.CarRental.domain.Claims;
import com.CarRental.factories.ClaimsFactory;
import com.CarRental.repositories.ClaimsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClaimsRepositoryImplTest {

    private ClaimsRepository repository;
    private Claims claims;

    private Claims getSavedClaims() {
        Set<Claims> savedClaimss = this.repository.getAll();
        return savedClaimss.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.claims);
    }

    @Test
    public void b_read() {
       Claims savedClaims = getSavedClaims();
        System.out.println("In read, claimsId = "+ savedClaims.getClaimsId());
        Claims read = this.repository.read(savedClaims.getClaimsId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedClaims, read);
    }

    @Test
    public void e_delete() {
        Claims savedClaims = getSavedClaims();
        this.repository.delete(savedClaims.getClaimsId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Claims Name";
        Claims claims = new Claims.Builder().copy(getSavedClaims()).claimProvider(newname).build();
        System.out.println("In update, about_to_updated = " + claims);
        Claims updated = this.repository.update(claims);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getClaimProvider());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Claims> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
