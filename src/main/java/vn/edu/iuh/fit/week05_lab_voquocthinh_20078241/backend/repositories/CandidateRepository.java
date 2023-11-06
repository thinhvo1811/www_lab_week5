package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Job;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByUserUsernameAndUserPassword(String username, String password);

    @Query("SELECT c FROM Candidate c WHERE c.id IN (SELECT cs.candidate.id FROM CandidateSkill cs WHERE cs.skill.id  IN (SELECT js.skill.id FROM JobSkill js WHERE js.job.id = :job))")
    List<Candidate> findProposedCandidates(@Param("job") long jobID);
}
