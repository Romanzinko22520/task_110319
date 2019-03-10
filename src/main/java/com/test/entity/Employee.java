package com.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "tblEmployees")
public class Employee {

    @Id
    @Column(name = "empID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "empName")
    private String name;
    @Column(name = "empActive")
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "dpID" )
    private Department department;

}
