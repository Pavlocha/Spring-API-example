package com.mehdi.spring.foodapi.services;

import java.util.List;

public interface CRUDService<T> {
    List<?> listALL();

    T getByID(int id);

    T saveOrUpdate(T domainObject);

    void delete(int id);
}
