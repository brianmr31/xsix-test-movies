package com.example.xsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xsis.entity.BarangEntity;
import com.example.xsis.service.BarangService;

@RestController
public class BarangController {
 
    @Autowired
    private BarangService barangService;

    @GetMapping("/api/v1/barangs")
    public List<BarangEntity> findAll(){
        return this.barangService.findAll();
    }

    @GetMapping("/api/v1/barangs/{uuid}")
    public BarangEntity getById(@PathVariable("uuid") String id){
        return this.barangService.getById(id);
    }

    @PostMapping("/api/v1/barangs")
    public void save(BarangEntity barang){
        this.barangService.save(barang);
    }

    @DeleteMapping("/api/v1/barangs")
    public void delById(@PathVariable("uuid") String id){
        this.barangService.delById(id);
    }
}
