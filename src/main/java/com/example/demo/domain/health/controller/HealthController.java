package com.example.demo.domain.health.controller;

import com.example.demo.domain.health.controller.docs.HealthControllerDocs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthController implements HealthControllerDocs {

    @GetMapping("")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("I'm healthy");
    }
}
