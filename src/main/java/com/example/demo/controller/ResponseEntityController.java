package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

@RestController
public class ResponseEntityController {

    private Map<Integer, String> ageMap;

    private ResponseEntityController() {
        ageMap = new HashMap<>();
        ageMap.put(1, "Jane");
        ageMap.put(2, "Bill");
        ageMap.put(3, "Luke");
    }

    @GetMapping("/person/{personId}/name")
    public ResponseEntity<String> getPersonName(@PathVariable int personId) {
        return ofNullable(ageMap.get(personId))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
