package com.CarRental.service;

import com.CarRental.domain.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService extends IService<Contact, String>{
    List<Contact> getAll();
}
