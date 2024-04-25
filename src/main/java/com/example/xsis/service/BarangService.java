package com.example.xsis.service;

import java.util.List;

import com.example.xsis.entity.BarangEntity;

public interface BarangService {
    
    public List<BarangEntity> findAll();
    public BarangEntity getById(String id);
    public void save(BarangEntity barang);
    public void delById(String id);
}
