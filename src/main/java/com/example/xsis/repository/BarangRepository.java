package com.example.xsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.xsis.entity.BarangEntity;

@Repository
public interface BarangRepository extends JpaRepository<BarangEntity, String>{
    
}
