package com.example.xsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xsis.entity.BarangEntity;
import com.example.xsis.repository.BarangRepository;

@Service
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public List<BarangEntity> findAll() {
        return this.barangRepository.findAll();
    }

    @Override
    public BarangEntity getById(String id) {
        return this.barangRepository.getById(id);
    }

    @Override
    public void save(BarangEntity barang) {
        this.barangRepository.save(barang);
    }

    @Override
    public void delById(String id) {
        this.barangRepository.deleteById(id);
    }
    
}
