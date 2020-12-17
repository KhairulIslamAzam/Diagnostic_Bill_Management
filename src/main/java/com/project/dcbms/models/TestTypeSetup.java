package com.project.dcbms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestTypeSetup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "testTypeSetup", cascade = CascadeType.ALL)
    private List<Test> tests;
}
