package com.project.dcbms.services;

import com.project.dcbms.models.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {
    List<Test> findAll();
    void save(Test test);
    Optional<Test> findById(int id);
    void deleteById(int id);
}
