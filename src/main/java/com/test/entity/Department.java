package com.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "tblDepartments")
public class Department {

    @Id
    @Column(name = "dpID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dpName")
    private String name;
}
