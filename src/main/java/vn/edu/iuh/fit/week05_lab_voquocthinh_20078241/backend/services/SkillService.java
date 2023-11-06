package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Skill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.SkillRepository;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findSkillsNotBelongToCandidate(long canID){
        return skillRepository.findSkillsNotBelongToCandidate(canID);
    }

    public List<Skill> findSkillsNotBelongToJob(long jobID){
        return skillRepository.findSkillsNotBelongToJob(jobID);
    }

    public Skill findBySkillName(String name){
        return skillRepository.findBySkillName(name);
    }
}
