package com.revature.Francheska_Pina_P1.Util.Interface;

import java.sql.SQLException;
import java.util.List;

public interface Crudable<T> {

    // create
    T create(T newObject);

    // Read
    List<T> findAll();
    T findById(int id);

    T findByUsername(String username);
    // Update
    boolean update(T updatedObject);

    // Delete
    boolean delete(int id);
}
