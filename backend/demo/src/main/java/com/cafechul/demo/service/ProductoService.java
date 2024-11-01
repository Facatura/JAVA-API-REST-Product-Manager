package com.cafechul.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafechul.demo.entity.Producto;
import com.cafechul.demo.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    //findAll

    public List<Producto> productofindAll(){
        return productoRepository.findAll();
    }

    //findById
    public Producto productoFindById(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    //save
    public Producto productoSave(Producto producto){
        return productoRepository.save(producto);
    }

    //update
    public Producto productoUpdate(Long id, Producto producto) {
        Producto productoToUpdate = productoFindById(id);
        if (productoToUpdate != null) {
            // Actualizar los campos del producto
            productoToUpdate.setPrecio(producto.getPrecio());
            productoToUpdate.setTamanio(producto.getTamanio());
            productoToUpdate.setTipoCafe(producto.getTipoCafe());
            // Guardar el producto actualizado en la base de datos
            return productoRepository.save(productoToUpdate);
        }
        return null; // Retorna null si el producto no existe
    }



    // delete
    public void productoDelete(Long id){
        Producto productoToDelete = productoFindById(id);
        if(productoToDelete != null){
            productoRepository.deleteById(id);
        }
    }
}
