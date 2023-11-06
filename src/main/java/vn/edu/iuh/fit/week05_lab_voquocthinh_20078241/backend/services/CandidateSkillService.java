package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Skill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.CandidateSkillRepository;

import java.util.List;

@Service
public class CandidateSkillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    public List<CandidateSkill> findCandidateSkillByCandidate(Candidate candidate){
        return candidateSkillRepository.findCandidateSkillByCandidate(candidate);
    }
}
