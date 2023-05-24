package com.example.trainingdb.controllers;

import com.example.trainingdb.entity.AnotherForOtO;
import com.example.trainingdb.entity.ForOtO;
import com.example.trainingdb.repo.RepoForOtO;
import com.example.trainingdb.service.DbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/work")
public class DbController {
    private final DbService dbService;
    public DbController(DbService dbService){
        this.dbService = dbService;
    }
    @GetMapping(value = "/create_oto")
    public String createOtO(){
        dbService.saveOtO();
        return "successful";
    }
    @GetMapping(value="/delete_oto")
    @ResponseBody
    public String deleteOtO(@RequestParam int id){
        dbService.deleteOtO(id);
        return "successful";
    }
    @GetMapping(value = "/create_mto")
    public String createMtO(){
        dbService.saveMtO();
        return "successful";
    }
    @GetMapping(value="/delete_mto")
    @ResponseBody
    public String deleteMtO(@RequestParam int id){
        dbService.deleteMtO(id);
        return "successful";
    }
}
