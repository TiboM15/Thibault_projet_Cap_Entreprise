package fr.thibault.cap_entreprise.service.interfaces;



public interface DAOFindByIdInterface<T> {

    T findById(Long id);

}