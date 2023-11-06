package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.ids.JobSkillID;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.JobSkill;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillID> {
}
