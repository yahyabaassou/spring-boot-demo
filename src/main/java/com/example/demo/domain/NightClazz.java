package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class NightClazz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String speaker;

    @Column(nullable = false, unique = true)
    private String place;

    @Column(nullable = false)
    private LocalDate date;

    public long getId() {
        return id;
    }

}
