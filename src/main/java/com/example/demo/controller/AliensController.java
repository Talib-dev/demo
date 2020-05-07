package com.example.demo.controller;
import com.example.demo.dao.AliensRepo;
import com.example.demo.model.Aliens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
public class AliensController {
    @Autowired
    AliensRepo repo;

    @RequestMapping("/")
    public  String home(){
        return "home.jsp";
    }


    @RequestMapping("/addAliens")
    public  String addAliens(Aliens aliens){
        repo.save(aliens);
        return "home.jsp";
    }
    @PostMapping("/Alien")
    public  Aliens addAlien(Aliens aliens){
        repo.save(aliens);
        return aliens;
    }

//    jsp@RequestMapping("/getAlien")
//    public ModelAndView getAlien(@RequestParam("aid") int id){
//        ModelAndView modelAndView=new ModelAndView("showdata.jsp");
//        Aliens aliens=repo.findById(id).orElse(new Aliens());
//        modelAndView.addObject(aliens);
//        return modelAndView;
//    }
    @RequestMapping("/getAliens")
    public ModelAndView getAliens(){
        ModelAndView modelAndView=new ModelAndView("showdata.jsp");
        Aliens aliens= (Aliens) repo.findAll();
        modelAndView.addObject(aliens);
        return modelAndView;
    }

    @RequestMapping("/Aliens")
    public List<Aliens> Aliens(){
        return repo.findAll();
    }

    @RequestMapping("/Aliens/{aid}")
    public Optional<Aliens> getAlien(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }
}
