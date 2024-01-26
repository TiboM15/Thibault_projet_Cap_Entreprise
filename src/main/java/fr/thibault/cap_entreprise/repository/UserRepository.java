package fr.thibault.cap_entreprise.repository;

import fr.thibault.cap_entreprise.entity.Classification;
import fr.thibault.cap_entreprise.entity.User;
import fr.thibault.cap_entreprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long>
{

    Optional<User> findByNickname(String nickname);

    Optional<Object> findByEmail(String email);
}