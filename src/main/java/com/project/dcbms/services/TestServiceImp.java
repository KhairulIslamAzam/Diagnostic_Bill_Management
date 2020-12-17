package com.project.dcbms.services;

import com.project.dcbms.models.Test;
import com.project.dcbms.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImp implements TestService {
    private TestRepository testRepository;

    @Autowired
    public TestServiceImp(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public void save(Test test) {
        testRepository.save(test);
    }

    @Override
    public Optional<Test> findById(int id) {
        return testRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
            testRepository.deleteById(id);
    }
}
