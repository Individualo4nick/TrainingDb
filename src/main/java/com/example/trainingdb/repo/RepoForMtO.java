package com.example.trainingdb.repo;

import com.example.trainingdb.entity.ForMtO;
import com.example.trainingdb.entity.ForOtO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoForMtO extends JpaRepository<ForMtO, Integer> {
}
