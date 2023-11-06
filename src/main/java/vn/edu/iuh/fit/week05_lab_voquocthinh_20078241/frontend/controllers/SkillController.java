package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Experience;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Skill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services.SkillService;

import java.util.List;

@Controller
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private SkillRepository skillRepository;
    @GetMapping("/skills")
    public ModelAndView showExperienceList(
            @SessionAttribute("candidate-account") Candidate candidate) {
        ModelAndView modelAndView = new ModelAndView();
        List<Skill> skills = skillService.findSkillsNotBelongToCandidate(candidate.getId());
        modelAndView.addObject("skills", skills);
        modelAndView.setViewName("skills/skills");
        return modelAndView;
    }

    @GetMapping("/show-add-candidate-skill-form/{id}")
    public ModelAndView showAddExperienceForm(
            @PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        CandidateSkill candidateSkill = new CandidateSkill();
        modelAndView.addObject("candidateSkill", candidateSkill);
        modelAndView.addObject("skill", skillRepository.findById(id).get());
        modelAndView.addObject("skillLevels", SkillLevel.values());
        modelAndView.setViewName("skills/candidateSkillAddForm");
        return modelAndView;
    }
}
