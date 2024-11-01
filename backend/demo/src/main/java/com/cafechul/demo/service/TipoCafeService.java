package com.cafechul.demo.service;

import java.util.List;

import com.cafechul.demo.entity.Tamanio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafechul.demo.entity.TipoCafe;
import com.cafechul.demo.repository.TipoCafeRepository;

@Service
public class TipoCafeService {
    @Autowired
    TipoCafeRepository tipoCafeRepository;
    
    //findAll

    public List<TipoCafe> tipoCafefindAll(){
        return tipoCafeRepository.findAll();
    }

    //findById
    public TipoCafe tipoCafeFindById(Long id){
        return tipoCafeRepository.findById(id).orElse(null);
    }

    //save
    public TipoCafe tipoCafeSave(TipoCafe tipoCafe){
        return tipoCafeRepository.save(tipoCafe);
    }

    //update
    public TipoCafe tipoCafeUpdate(Long id, TipoCafe tipoCafe) {
        TipoCafe tipoCafeToUpdate = tipoCafeFindById(id);
        if (tipoCafeToUpdate != null) {
            // Actualizar los campos del producto
            tipoCafeToUpdate.setNombre(tipoCafe.getNombre());
            // Guardar el producto actualizado en la base de datos
            return tipoCafeRepository.save(tipoCafeToUpdate);
        }
        return null; // Retorna null si el producto no existe
    }

    // delete
    public void tipoCafeDelete(Long id){
        TipoCafe tipoCafeToDelete = tipoCafeFindById(id);
        if(tipoCafeToDelete != null){
            tipoCafeRepository.deleteById(id);
        }
    }
}
