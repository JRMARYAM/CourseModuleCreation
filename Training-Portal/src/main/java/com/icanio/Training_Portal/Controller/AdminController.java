package com.icanio.Training_Portal.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequiredArgsConstructor
public class AdminController {
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/Admin")

    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Say Hello Admin");
    }
}
