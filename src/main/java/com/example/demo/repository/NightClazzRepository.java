package com.example.demo.repository;

import com.example.demo.domain.NightClazz;
import org.springframework.data.repository.CrudRepository;

public interface NightClazzRepository extends CrudRepository<NightClazz, Long> {

    NightClazz findByTitle(String title);

}