package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.Tamanio;



@Repository
public interface TamanioRepository extends JpaRepository<Tamanio,Long>{

}
