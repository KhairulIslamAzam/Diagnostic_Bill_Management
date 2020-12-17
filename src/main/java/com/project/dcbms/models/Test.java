package com.project.dcbms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "test")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "fee")
    private Double fee;

    @ManyToOne(fetch = FetchType.LAZY,
                cascade = { CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH})
    @JoinColumn(name = "testtype_id")
    private TestTypeSetup testTypeSetup;

}
