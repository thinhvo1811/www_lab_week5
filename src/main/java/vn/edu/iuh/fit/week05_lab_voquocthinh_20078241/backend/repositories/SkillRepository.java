package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Skill;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Query("select s from Skill s where s.id not in (select c.skill.id from CandidateSkill c where c.candidate.id = :canID)")
    List<Skill> findSkillsNotBelongToCandidate(@Param("canID") long canID);

    @Query("select s from Skill s where s.id not in (select j.skill.id from JobSkill j where j.job.id = :jobID)")
    List<Skill> findSkillsNotBelongToJob(@Param("jobID") long jobID);

    Skill findBySkillName(String name);
}
