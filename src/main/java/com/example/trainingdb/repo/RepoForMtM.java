package com.example.trainingdb.repo;

import com.example.trainingdb.entity.ForMtM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoForMtM extends JpaRepository<ForMtM, Integer> {
}
