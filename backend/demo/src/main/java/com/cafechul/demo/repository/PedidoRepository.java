package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.Pedido;



@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long>{

}
