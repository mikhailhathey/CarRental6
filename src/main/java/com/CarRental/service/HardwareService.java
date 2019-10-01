package com.CarRental.service;

import com.CarRental.domain.Hardware;

import java.util.List;

public interface HardwareService extends IService<Hardware, String>{
    List<Hardware> getAll();
}
