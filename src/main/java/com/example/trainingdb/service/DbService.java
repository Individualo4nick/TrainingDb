package com.example.trainingdb.service;

import com.example.trainingdb.entity.AnotherForOtO;
import com.example.trainingdb.entity.ForOtO;
import com.example.trainingdb.repo.RepoForAnOtO;
import com.example.trainingdb.repo.RepoForOtO;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    private final RepoForOtO repoForOtO;
    private final RepoForAnOtO repoForAnOtO;
    public DbService(RepoForOtO repoForOtO, RepoForAnOtO repoForAnOtO){
        this.repoForOtO = repoForOtO;
        this.repoForAnOtO = repoForAnOtO;
    }
    public void saveOtO(){
        AnotherForOtO anotherForOtO = new AnotherForOtO();
        anotherForOtO.setTitle("another_example1");
        ForOtO forOtO = new ForOtO();
        forOtO.setTitle("example1");
        forOtO.setAnotherForOtO(anotherForOtO);
        repoForOtO.save(forOtO);
    }
    public void deleteOtO(int id){
        try {
            repoForAnOtO.deleteById(id);
        }
        catch (Exception e){
            System.out.println("Отловлена ошибка, так как происходит нарушение ограничения внешнего ключа");
        }
        repoForOtO.deleteById(id);
    }
}
