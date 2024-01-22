package fr.thibault.cap_entreprise.service;

import java.util.List;

public interface DAOServiceInterface<T> {

    List<T> findAll();

    T findById(Long id);

}
