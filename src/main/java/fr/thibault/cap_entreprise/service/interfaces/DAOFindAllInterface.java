package fr.thibault.cap_entreprise.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

import java.util.List;

public interface DAOFindAllInterface<T> {

    List<T> findAll();

}