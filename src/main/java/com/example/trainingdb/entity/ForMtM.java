package com.example.trainingdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="for_mtm")
public class ForMtM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "mtm_table",
            joinColumns = @JoinColumn(name = "for_mtm_id"),
            inverseJoinColumns = @JoinColumn(name = "a_for_mtm_id"))
    private List<AnotherForMtM> list;

}
