package com.cafechul.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafechul.demo.entity.DetallesPedido;
import com.cafechul.demo.repository.DetallesPedidoRepository;

@Service
public class DetallesPedidoService {
    @Autowired
    DetallesPedidoRepository detallesPedidoRepository;

    //findAll
    public List<DetallesPedido> detallesPedidofindAll(){
        return detallesPedidoRepository.findAll();
    }

    //findById
    public DetallesPedido detallesPedidoFindById(Long id){
        return detallesPedidoRepository.findById(id).orElse(null);
    }

    //save
    public DetallesPedido detallesPedidoSave(DetallesPedido detallesPedido){
        return detallesPedidoRepository.save(detallesPedido);
    }

    //update
    public DetallesPedido detallesPedidoUpdate(Long id, DetallesPedido detallesPedido) {
        DetallesPedido detallesPedidoToUpdate = detallesPedidoFindById(id);
        if (detallesPedidoToUpdate != null) {
            // Actualizar los campos del producto
            detallesPedidoToUpdate.setCantidad(detallesPedido.getCantidad());
            // Guardar el producto actualizado en la base de datos
            return detallesPedidoRepository.save(detallesPedidoToUpdate);
        }
        return null; // Retorna null si el producto no existe
    }

    // delete
    /*public void productoDelete(Long id){
        Producto productoToDelete = productoFindById(id);
        if(productoToDelete != null){
            productoRepository.deleteById(id);
        }
    }*/
}
