package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Candidate;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Job;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.CandidateRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);//findFirst.../findTop...
    }

    public Page<Candidate> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Candidate> list;
        List<Candidate> candidates = candidateRepository.findAll();

        if (candidates.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, candidates.size());
            list = candidates.subList(startItem, toIndex);
        }

        Page<Candidate> candidatePage
                = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), candidates.size());

        return candidatePage;
    }

    public Candidate findByUsernameAndPassword(String username, String password){
        return candidateRepository.findByUserUsernameAndUserPassword(username, password);
    }

    public Page<Candidate> findProposedCandidatesPaginated(int pageNo, int pageSize, long jobID) {
        int startItem = pageNo * pageSize;
        List<Candidate> list;
        List<Candidate> candidates = candidateRepository.findProposedCandidates(jobID);

        if (candidates.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, candidates.size());
            list = candidates.subList(startItem, toIndex);
        }

        Page<Candidate> candidatePage
                = new PageImpl<>(list, PageRequest.of(pageNo, pageSize), candidates.size());

        return candidatePage;
    }
}
