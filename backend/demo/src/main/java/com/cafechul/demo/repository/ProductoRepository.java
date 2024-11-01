package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.Producto;



@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{

}
