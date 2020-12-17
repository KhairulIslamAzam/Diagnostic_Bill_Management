package com.project.dcbms.repositories;

import com.project.dcbms.models.TestTypeSetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTypeRepository extends JpaRepository<TestTypeSetup, Integer> {

}
