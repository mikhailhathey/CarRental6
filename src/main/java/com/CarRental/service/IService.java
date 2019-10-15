package com.CarRental.service;

public interface IService<T, ID> {
    T create(T t);

    T read(Integer id);

    T update(T t);

    void delete(Integer id);
}
