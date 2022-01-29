package de.djgummikuh.minimal.repo;

import de.djgummikuh.minimal.dm.ChallengeEntity;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository<ChallengeEntity, String> {
}
