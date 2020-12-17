package com.project.dcbms.services;

import com.project.dcbms.models.TestTypeSetup;
import com.project.dcbms.repositories.TestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestTypeSetupServiceImp implements TestTypeSetupService {

    private TestTypeRepository testTypeRepository;

    @Autowired
    public TestTypeSetupServiceImp(TestTypeRepository testTypeRepository) {
        this.testTypeRepository = testTypeRepository;
    }

    @Override
    public List<TestTypeSetup> findAll() {
        return testTypeRepository.findAll();
    }

    @Override
    public void save(TestTypeSetup testTypeSetup) {
        testTypeRepository.save(testTypeSetup);
    }

    @Override
    public TestTypeSetup findById(int id) {
        TestTypeSetup testTypeSetup = testTypeRepository.findById(id).get();
        return testTypeSetup;
    }

    @Override
    public void deleteById(int id) {
        testTypeRepository.deleteById(id);
    }
}
