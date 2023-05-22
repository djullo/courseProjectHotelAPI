package com.ua.robodream.courseProject.controller;

import com.ua.robodream.courseProject.model.Visitor;
import com.ua.robodream.courseProject.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        List<Visitor> visitors = visitorService.getAllVisitors();
        return ResponseEntity.ok(visitors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {
        Visitor visitor = visitorService.getVisitorById(id);
        if (visitor != null) {
            return ResponseEntity.ok(visitor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<Visitor>> getVisitorsByLastName(@PathVariable String lastName) {
        List<Visitor> visitors = visitorService.getVisitorsByLastName(lastName);
        return ResponseEntity.ok(visitors);
    }

    @GetMapping("/passport/{passportNumber}")
    public ResponseEntity<Visitor> getVisitorByPassportNumber(@PathVariable String passportNumber) {
        Visitor visitor = visitorService.getVisitorByPassportNumber(passportNumber);
        if (visitor != null) {
            return ResponseEntity.ok(visitor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Visitor> saveVisitor(@RequestBody Visitor visitor) {
        Visitor savedVisitor = visitorService.saveVisitor(visitor);
        return ResponseEntity.ok(savedVisitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
        return ResponseEntity.noContent().build();
    }
}