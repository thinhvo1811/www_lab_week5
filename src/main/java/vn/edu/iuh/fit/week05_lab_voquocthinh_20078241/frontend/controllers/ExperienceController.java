package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Experience;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.ExperienceRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ExperienceController {
    @Autowired
    private ExperienceRepository experienceRepository;

    @GetMapping("/experiences")
    public ModelAndView showExperienceList(
            @SessionAttribute("candidate-account") Candidate candidate) {
        ModelAndView modelAndView = new ModelAndView();
        List<Experience> experiences = experienceRepository.findExperiencesByCandidate(candidate);
        modelAndView.addObject("experiences", experiences);
        modelAndView.setViewName("experiences/experiences");
        return modelAndView;
    }

    @GetMapping("/show-update-exp-form/{id}")
    public ModelAndView showUpdateExperienceForm(
            @PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Experience> experience = experienceRepository.findById(id);
        modelAndView.addObject("experience", experience.get());
        modelAndView.setViewName("experiences/experienceUpdateForm");
        return modelAndView;
    }

    @PostMapping ("/experiences/update")
    public ModelAndView update(
            @ModelAttribute("experience") Experience experience) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Experience> experience1 = experienceRepository.findById(experience.getId());
        if (experience1.isPresent()){
            experience1.get().setFromDate(experience.getFromDate());
            experience1.get().setToDate(experience.getToDate());
            experience1.get().setCompanyName(experience.getCompanyName());
            experience1.get().setRole(experience.getRole());
            experience1.get().setWorkDescription(experience.getWorkDescription());
            experienceRepository.save(experience1.get());
        }
        modelAndView.setViewName("redirect:/show-update-exp-form/"+experience1.get().getId());
        return modelAndView;
    }

    @GetMapping("/experiences/delete/{id}")
    public ModelAndView delete(
            @PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        experienceRepository.deleteById(id);
        modelAndView.setViewName("redirect:/experiences");
        return modelAndView;
    }

    @GetMapping("/show-add-exp-form")
    public ModelAndView showAddExperienceForm() {
        ModelAndView modelAndView = new ModelAndView();
        Experience experience = new Experience();
        modelAndView.addObject("experience", experience);
        modelAndView.setViewName("experiences/experienceAddForm");
        return modelAndView;
    }

    @PostMapping ("/experiences/add")
    public ModelAndView add(
            @ModelAttribute("experience") Experience experience,
            @SessionAttribute("candidate-account") Candidate candidate) {
        ModelAndView modelAndView = new ModelAndView();
        experience.setCandidate(candidate);
        experienceRepository.save(experience);
        modelAndView.setViewName("redirect:/experiences");
        return modelAndView;
    }
}
