package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.TipoCafe;



@Repository
public interface TipoCafeRepository extends JpaRepository<TipoCafe,Long>{

}
