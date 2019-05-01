package com.CarRental.repositories;

public interface CrudRepository<T, ID> {
    T create(T t);
    T update(T t);
    void delete(ID id);
    T read(ID id);
}
