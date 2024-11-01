package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.MetodoDePago;



@Repository
public interface MetodoDePagoRepository extends JpaRepository<MetodoDePago,Long>{

}
