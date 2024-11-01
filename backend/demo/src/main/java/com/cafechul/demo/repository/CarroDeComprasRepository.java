package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.CarroDeCompras;



@Repository
public interface CarroDeComprasRepository extends JpaRepository<CarroDeCompras,Long>{

}
