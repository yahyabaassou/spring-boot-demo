package com.example.demo.service;

import com.example.demo.domain.NightClazz;
import com.example.demo.exception.NightClazzIdMismatchException;
import com.example.demo.exception.NightClazzNotFoundException;
import com.example.demo.repository.NightClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NightClazzService {

    @Autowired
    private NightClazzRepository nightClazzRepository;

    public List<NightClazz> findAll() {
        //Iterable to List
        return StreamSupport.stream(nightClazzRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public NightClazz findByTitle(String title) {
        return nightClazzRepository.findByTitle(title);
    }

    public NightClazz findOne(Long id) {
        return getNightClazzById(id);
    }

    public NightClazz create(NightClazz nightClazz) {
        return nightClazzRepository.save(nightClazz);
    }

    public void delete(Long id) {
        NightClazz nightClazz = getNightClazzById(id);
        nightClazzRepository.delete(nightClazz);
    }

    public NightClazz update(NightClazz nightClazz, Long id) {
        if (nightClazz.getId() != id) {
            throw new NightClazzIdMismatchException("NightClazz id is not the same as parameter id");
        }
        getNightClazzById(id);
        return nightClazzRepository.save(nightClazz);
    }

    private NightClazz getNightClazzById(Long id) {
        return nightClazzRepository.findById(id)
                .orElseThrow(() -> new NightClazzNotFoundException("NightClazz with id " + id + " not found"));
    }
}
