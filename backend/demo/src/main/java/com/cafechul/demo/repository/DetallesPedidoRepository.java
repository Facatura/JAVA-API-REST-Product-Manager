package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.DetallesPedido;



@Repository
public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido,Long>{

}
