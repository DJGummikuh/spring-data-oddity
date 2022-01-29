package de.djgummikuh.minimal.repo;

import de.djgummikuh.minimal.dm.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
