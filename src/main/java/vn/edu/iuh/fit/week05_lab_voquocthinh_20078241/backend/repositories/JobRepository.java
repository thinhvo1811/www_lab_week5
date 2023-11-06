package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE j.id IN (SELECT js.job.id FROM JobSkill js WHERE js.skill.id  IN (SELECT cs.skill.id FROM CandidateSkill cs WHERE cs.candidate.id = :candidate))")
    List<Job> findProposedJobs(@Param("candidate") long candidateID);

    List<Job> findJobsByCompany(Company company);
}
