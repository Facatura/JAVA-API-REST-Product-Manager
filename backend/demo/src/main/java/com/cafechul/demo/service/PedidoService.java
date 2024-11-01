package com.cafechul.demo.service;

import java.util.List;

import com.cafechul.demo.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafechul.demo.entity.Pedido;
import com.cafechul.demo.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    //findAll

    public List<Pedido> pedidofindAll(){
        return pedidoRepository.findAll();
    }

    //findById
    public Pedido pedidoFindById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    //save
    public Pedido pedidoSave(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    //update

    public Pedido pedidoUpdate(Long id, Pedido pedido) {
        Pedido pedidoToUpdate = pedidoFindById(id);
        if (pedidoToUpdate != null) {
            // Actualizar los campos del producto
            //pedidoToUpdate.setFechaCreacion(pedido.getFechaCreacion());
            pedidoToUpdate.setPrecioFinal(pedido.getPrecioFinal());
            // Guardar el producto actualizado en la base de datos
            return pedidoRepository.save(pedidoToUpdate);
        }
        return null; // Retorna null si el producto no existe
    }



    // delete
    public void pedidoDelete(Long id){
        Pedido pedidoToDelete = pedidoFindById(id);
        if(pedidoToDelete != null){
            pedidoRepository.deleteById(id);
        }
    }
}
