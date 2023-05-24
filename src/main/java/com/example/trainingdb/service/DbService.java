package com.example.trainingdb.service;

import com.example.trainingdb.entity.AnotherForOtO;
import com.example.trainingdb.entity.ForMtO;
import com.example.trainingdb.entity.ForOtM;
import com.example.trainingdb.entity.ForOtO;
import com.example.trainingdb.repo.RepoForAnOtO;
import com.example.trainingdb.repo.RepoForMtO;
import com.example.trainingdb.repo.RepoForOtM;
import com.example.trainingdb.repo.RepoForOtO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbService {
    private final RepoForOtO repoForOtO;
    private final RepoForAnOtO repoForAnOtO;
    private final RepoForOtM repoForOtM;
    private final RepoForMtO repoForMtO;
    public DbService(RepoForOtO repoForOtO, RepoForAnOtO repoForAnOtO, RepoForOtM repoForOtM, RepoForMtO repoForMtO){
        this.repoForOtO = repoForOtO;
        this.repoForAnOtO = repoForAnOtO;
        this.repoForOtM = repoForOtM;
        this.repoForMtO = repoForMtO;
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
    public void saveMtO(){
        ForMtO forMtO = new ForMtO();
        forMtO.setTitle("another_example1");
        ForMtO forMtO1 = new ForMtO();
        forMtO1.setTitle("another_example1");
        ForOtM forOtM = new ForOtM();
        forOtM.setTitle("example1");
        forMtO.setForOtM(forOtM);
        forMtO1.setForOtM(forOtM);
        List<ForMtO> list = new ArrayList<>();
        list.add(forMtO);
        list.add(forMtO1);
        forOtM.setList(list);
        repoForMtO.save(forMtO);
        repoForMtO.save(forMtO1);
    }
    public void deleteMtO(int id){
        try {
            repoForOtM.deleteById(id);
        }
        catch (Exception e){
            System.out.println("Отловлена ошибка, так как происходит нарушение ограничения внешнего ключа");
        }
        repoForMtO.deleteById(id);
    }
}
