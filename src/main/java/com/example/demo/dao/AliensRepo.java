package com.example.demo.dao;

import com.example.demo.model.Aliens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AliensRepo extends JpaRepository<Aliens,Integer> {

}
