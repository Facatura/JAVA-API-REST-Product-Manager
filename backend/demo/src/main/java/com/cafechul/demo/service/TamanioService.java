package com.cafechul.demo.service;

import java.util.List;

import com.cafechul.demo.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafechul.demo.entity.Tamanio;
import com.cafechul.demo.repository.TamanioRepository;

@Service
public class TamanioService {
    @Autowired
    TamanioRepository tamanioRepository;

    //findAll

    public List<Tamanio> tamaniofindAll(){
        return tamanioRepository.findAll();
    }

    //findById
    public Tamanio tamanioFindById(Long id){
        return tamanioRepository.findById(id).orElse(null);
    }

    //save
    public Tamanio tamanioSave(Tamanio tamanio){
        return tamanioRepository.save(tamanio);
    }

    //update

    public Tamanio tamanioUpdate(Long id, Tamanio tamanio) {
        Tamanio tamanioToUpdate = tamanioFindById(id);
        if (tamanioToUpdate != null) {
            // Actualizar los campos del producto
            tamanioToUpdate.setNombre(tamanio.getNombre());
            // Guardar el producto actualizado en la base de datos
            return tamanioRepository.save(tamanioToUpdate);
        }
        return null; // Retorna null si el producto no existe
    }



    // delete
    public void tamanioDelete(Long id){
        Tamanio tamanioToDelete = tamanioFindById(id);
        if(tamanioToDelete != null){
            tamanioRepository.deleteById(id);
        }
    }
    }
