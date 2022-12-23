package com.moles.h2.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;

    @Column(name = "person_name")
    private String name;
}
