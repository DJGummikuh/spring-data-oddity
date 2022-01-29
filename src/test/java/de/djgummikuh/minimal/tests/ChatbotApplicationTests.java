package de.djgummikuh.minimal.tests;

import de.djgummikuh.minimal.dm.ChallengeEntity;
import de.djgummikuh.minimal.dm.SolutionEntity;
import de.djgummikuh.minimal.dm.UserEntity;
import de.djgummikuh.minimal.repo.ChallengeRepository;
import de.djgummikuh.minimal.repo.SolutionRepository;
import de.djgummikuh.minimal.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest(properties = { "spring.datasource.url=jdbc:h2:mem:mydb" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ChatbotApplicationTests {

	@Autowired
	ChallengeRepository challengeRepo;
	@Autowired
	SolutionRepository solutionRepository;
	@Autowired
	UserRepository userRepo;


	@Test
	void contextLoads() {
		ChallengeEntity ce = new ChallengeEntity();
		ce.setId("challenge1");
		ce.setSolutions(new LinkedList<>());
		ce = challengeRepo.save(ce);

		UserEntity ue = new UserEntity("user1",true,null, null, "1", "de", null, null, new LinkedList<>(), new LinkedList<>());
		ue = userRepo.save(ue);

		SolutionEntity se = new SolutionEntity();
		se.setChallenge(ce);
		se.setUser(ue);
		se.setIssuedOn(System.currentTimeMillis());
		List<String> vals = Arrays.asList("Solution Value 1", "Solution Value 2");
		se.setSolutionValues(vals);
		se = solutionRepository.save(se);

		// Load the Challenge via findAllById
		ChallengeEntity fromPersistenceFindAll = challengeRepo.findAllById(Arrays.asList("challenge1")).iterator().next();
		// We only saved a single solution, so we expect one solution to come back.
		Assertions.assertEquals(1, fromPersistenceFindAll.getSolutions().size());
		// Now load the SAME challenge individually via findById
		ChallengeEntity fromPersistenceFindById = challengeRepo.findById("challenge1").get();
		// We expect the entity to have the exact same number of solutions like the other one, should be easy-peasy, right?
		Assertions.assertEquals(fromPersistenceFindById.getSolutions().size(), fromPersistenceFindAll.getSolutions().size(), "Solution list sizes from both ways should be identical but they are not!");
	}
}
