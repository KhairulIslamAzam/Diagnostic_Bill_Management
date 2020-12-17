package com.project.dcbms.services;

import com.project.dcbms.models.TestTypeSetup;

import java.util.List;
import java.util.Optional;

public interface TestTypeSetupService {
    List<TestTypeSetup> findAll();
    void save(TestTypeSetup testTypeSetup);
    TestTypeSetup findById(int id);
    void deleteById(int id);
}
