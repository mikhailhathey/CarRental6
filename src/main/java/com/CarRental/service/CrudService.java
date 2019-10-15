package com.CarRental.service;

public interface CrudService<TYPE, ID> {
    TYPE create(TYPE type);
    TYPE update(TYPE type);
    void delete(Integer id);
    TYPE read(Integer id);
}