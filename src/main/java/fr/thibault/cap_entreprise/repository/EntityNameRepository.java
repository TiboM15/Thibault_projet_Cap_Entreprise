
package fr.thibault.cap_entreprise.repository;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}
