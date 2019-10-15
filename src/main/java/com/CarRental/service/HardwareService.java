package com.CarRental.service;

import com.CarRental.domain.Hardware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HardwareService extends IService<Hardware, String>{
    List<Hardware> getAll();
}
