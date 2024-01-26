package fr.thibault.cap_entreprise.service.interfaces;

import java.util.List;

public interface DAOEntityInterface<T> extends
        DAOFindByIdInterface<T>
{

    List<T> findAll();

}