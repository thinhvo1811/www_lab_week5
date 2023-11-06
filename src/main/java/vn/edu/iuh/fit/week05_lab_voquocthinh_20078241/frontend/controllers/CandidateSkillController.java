package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.ids.CandidateSkillID;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Experience;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Skill;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services.CandidateSkillService;

import java.util.List;
import java.util.Optional;

@Controller
public class CandidateSkillController {
    @Autowired
    private CandidateSkillService candidateSkillService;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/candidates/skills")
    public ModelAndView showCandidateSkillList(
            @SessionAttribute("candidate-account") Candidate candidate) {
        ModelAndView modelAndView = new ModelAndView();
        List<CandidateSkill> candidateSkills = candidateSkillService.findCandidateSkillByCandidate(candidate);
        modelAndView.addObject("candidateSkills", candidateSkills);
        modelAndView.setViewName("skills/candidateSkills");
        return modelAndView;
    }

    @GetMapping("/candidates/skills/delete")
    public ModelAndView delete(
            @RequestParam("skill-id") long skillID,
            @RequestParam("can-id") long canID) {
        ModelAndView modelAndView = new ModelAndView();
        candidateSkillRepository.delete(new CandidateSkill(skillRepository.findById(skillID).get(),candidateRepository.findById(canID).get()));
        modelAndView.setViewName("redirect:/candidates/skills");
        return modelAndView;
    }

    @PostMapping ("/candidates/skills/add")
    public ModelAndView add(
            @ModelAttribute("candidateSkill") CandidateSkill candidateSkill,
            @ModelAttribute("skill") Skill skill,
            @SessionAttribute("candidate-account") Candidate candidate) {
        ModelAndView modelAndView = new ModelAndView();
        candidateSkill.setSkill(skillRepository.findById(skill.getId()).get());
        candidateSkill.setCandidate(candidateRepository.findById(candidate.getId()).get());
        candidateSkillRepository.save(candidateSkill);
        modelAndView.setViewName("redirect:/candidates/skills");
        return modelAndView;
    }
}
