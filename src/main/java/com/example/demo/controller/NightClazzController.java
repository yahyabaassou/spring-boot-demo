package com.example.demo.controller;

import com.example.demo.domain.NightClazz;
import com.example.demo.service.NightClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nightclazz")
public class NightClazzController {

    @Autowired
    private NightClazzService nightClazzService;

    @GetMapping
    public List<NightClazz> findAll() {
        return nightClazzService.findAll();
    }

    @GetMapping("/title/{nightClazzTitle}")
    public NightClazz findByTitle(@PathVariable String nightClazzTitle) {
        return nightClazzService.findByTitle(nightClazzTitle);
    }

    @GetMapping("/{id}")
    public NightClazz findOne(@PathVariable Long id) {
        return  nightClazzService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NightClazz create(@RequestBody NightClazz nightClazz) {
        return nightClazzService.create(nightClazz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        nightClazzService.delete(id);
    }

    @PutMapping("/{id}")
    public NightClazz update(@RequestBody NightClazz nightClazz, @PathVariable Long id) {
        return nightClazzService.update(nightClazz, id);
    }
}
