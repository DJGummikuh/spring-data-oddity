package de.djgummikuh.minimal.repo;

import de.djgummikuh.minimal.dm.EvaluationEntity;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationRepository extends CrudRepository<EvaluationEntity, String> {
}
