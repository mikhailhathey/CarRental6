package com.CarRental.repositories.impl;

import com.CarRental.domain.Staff;
import com.CarRental.repositories.StaffRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class StaffRepositoryImpl implements StaffRepository {

    private static StaffRepositoryImpl repository = null;
    private Set<Staff> staff;

    private StaffRepositoryImpl(){
        this.staff = new HashSet<>();
    }

    private Staff findStaff(String staffId) {
        return this.staff.stream()
                .filter(staff -> staff.getStaffId().trim().equals(staffId))
                .findAny()
                .orElse(null);
    }

    public static StaffRepositoryImpl getRepository(){
        if (repository == null) repository = new StaffRepositoryImpl();
        return repository;
    }


    public Staff create(Staff staff){
        this.staff.add(staff);
        return staff;
    }

    public Staff read(final String staffId){
        Staff staff = findStaff(staffId);
        return staff;
    }

    public void delete(String staffId) {
        Staff staff = findStaff(staffId);
        if (staff != null) this.staff.remove(staff);
    }

    public Staff update(Staff staff){
        Staff toDelete = findStaff(staff.getStaffId());
        if(toDelete != null) {
            this.staff.remove(toDelete);
            return create(staff);
        }
        return null;
    }


    public Set<Staff> getAll(){
        return this.staff;
    }
}
