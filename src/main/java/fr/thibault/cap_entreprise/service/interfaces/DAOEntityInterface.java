package fr.thibault.cap_entreprise.service.interfaces;

import java.util.List;

public interface DAOEntityInterface<T> extends
        DAOFindByIdInterface<T>,
        DAOFindAllInterface<T>
{

    List<T> findAll();

}