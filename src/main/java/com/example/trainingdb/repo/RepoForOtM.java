package com.example.trainingdb.repo;

import com.example.trainingdb.entity.ForOtM;
import com.example.trainingdb.entity.ForOtO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoForOtM extends JpaRepository<ForOtM, Integer> {
}
