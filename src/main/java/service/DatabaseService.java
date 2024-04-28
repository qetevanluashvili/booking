package service;

import Dto.HotelDTO;

import java.util.Map;

public interface DatabaseService<T, ID> {
    Map<ID, T> getAll();
    T getById(ID id);
    void add(T entity);
    void update(ID id, T entity);

    void add(HotelDTO entity);

    void delete(ID id);
}
