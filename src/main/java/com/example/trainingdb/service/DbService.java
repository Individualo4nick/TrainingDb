package com.example.trainingdb.service;

import com.example.trainingdb.entity.*;
import com.example.trainingdb.repo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbService {
    private final RepoForOtO repoForOtO;
    private final RepoForAnOtO repoForAnOtO;
    private final RepoForOtM repoForOtM;
    private final RepoForMtO repoForMtO;
    private final RepoForMtM repoForMtM;
    public DbService(RepoForOtO repoForOtO, RepoForAnOtO repoForAnOtO, RepoForOtM repoForOtM, RepoForMtO repoForMtO, RepoForMtM repoForMtM){
        this.repoForOtO = repoForOtO;
        this.repoForAnOtO = repoForAnOtO;
        this.repoForOtM = repoForOtM;
        this.repoForMtO = repoForMtO;
        this.repoForMtM = repoForMtM;
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
//        ForMtO forMtO = new ForMtO();
//        forMtO.setTitle("another_example2");
//        ForMtO forMtO1 = new ForMtO();
//        forMtO1.setTitle("another_example2");
//        ForOtM forOtM = new ForOtM();
//        forOtM.setTitle("example2");
//        forMtO.setForOtM(forOtM);
//        forMtO1.setForOtM(forOtM);
//        List<ForMtO> list = new ArrayList<>();
//        list.add(forMtO);
//        list.add(forMtO1);
//        forOtM.setList(list);
//        repoForMtO.save(forMtO);
//        repoForMtO.save(forMtO1);
        ForMtO forMtO = new ForMtO();
        forMtO.setTitle("another_example2");
        ForMtO forMtO1 = new ForMtO();
        forMtO1.setTitle("another_example2");
        ForOtM forOtM = new ForOtM();
        forOtM.setTitle("example2");
        forMtO.setForOtM(forOtM);
        forMtO1.setForOtM(forOtM);
        List<ForMtO> list = new ArrayList<>();
        list.add(forMtO);
        list.add(forMtO1);
        forOtM.setList(list);
        repoForOtM.save(forOtM);
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
    public void saveMtM() {
        AnotherForMtM anotherForMtM = new AnotherForMtM();
        anotherForMtM.setTitle("another_example3");
        AnotherForMtM anotherForMtM1 = new AnotherForMtM();
        anotherForMtM1.setTitle("another_example3");
        ForMtM forMtM = new ForMtM();
        forMtM.setTitle("example3");
        ForMtM forMtM1 = new ForMtM();
        forMtM1.setTitle("example3");
        List<AnotherForMtM> list = new ArrayList<>();
        list.add(anotherForMtM);
        list.add(anotherForMtM1);
        List<ForMtM> list1 = new ArrayList<>();
        list1.add(forMtM);
        list1.add(forMtM1);
        forMtM.setList(list);
        anotherForMtM.setList(list1);
        repoForMtM.save(forMtM);
    }
    public void deleteMtM(int id) {
        repoForMtM.deleteById(id);
    }
}
