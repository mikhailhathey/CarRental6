package com.CarRental.service;

import com.CarRental.domain.Hardware;

import java.util.Set;

public interface HardwareService extends CrudService<Hardware, String>{
    Set<Hardware> getAll();
}
