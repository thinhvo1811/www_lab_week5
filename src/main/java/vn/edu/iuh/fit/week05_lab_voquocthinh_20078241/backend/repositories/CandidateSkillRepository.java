package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.ids.CandidateSkillID;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Skill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services.CandidateSkillService;

import java.util.List;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillID> {
    List<CandidateSkill> findCandidateSkillByCandidate(Candidate candidate);
}
