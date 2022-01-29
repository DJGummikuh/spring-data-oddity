package de.djgummikuh.minimal.repo;

import de.djgummikuh.minimal.dm.SolutionEntity;
import de.djgummikuh.minimal.dm.UserEntity;
import de.djgummikuh.minimal.dm.ChallengeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface SolutionRepository extends CrudRepository<SolutionEntity, Long> {

    List<SolutionEntity> findAllByUserIsNotAndChallengeIsInOrderByIssuedOnAsc(UserEntity user, Collection<ChallengeEntity> challenges);

    List<SolutionEntity> findAllByChallengeAndUser(ChallengeEntity challenge, UserEntity user);
}
