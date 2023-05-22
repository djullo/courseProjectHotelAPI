package com.ua.robodream.courseProject.service;

import com.ua.robodream.courseProject.model.Visitor;
import com.ua.robodream.courseProject.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getVisitorById(Long visitorId) {
        Optional<Visitor> optionalVisitor = visitorRepository.findById(visitorId);
        return optionalVisitor.orElse(null);
    }

    public Visitor saveVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public void deleteVisitor(Long id) {
        visitorRepository.deleteById(id);
    }

    public List<Visitor> getVisitorsByLastName(String lastName) {
        return visitorRepository.findByLastName(lastName);
    }

    public Visitor getVisitorByPassportNumber(String passportNumber) {
        return visitorRepository.findByPassportNumber(passportNumber);
    }
}