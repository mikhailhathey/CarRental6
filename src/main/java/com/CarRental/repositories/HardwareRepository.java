package com.CarRental.repositories;

import com.CarRental.domain.Hardware;

import java.util.Set;


public interface HardwareRepository extends CrudRepository<Hardware, String> {

    Set<Hardware> getAll();
}
