
package fr.thibault.cap_entreprise.repository.interfaces;

import java.util.Optional;

public interface EntityNomenclatureRepository<T> {

    Optional<T> findByName(String name);

    Optional<T> findBySlug(String slug);

}
