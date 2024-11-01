package com.cafechul.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafechul.demo.entity.ElementoDelCarro;



@Repository
public interface ElementoDelCarroRepository extends JpaRepository<ElementoDelCarro,Long>{

}
