package com.cafechul.demo.controller;
/* cosas necesarias que el mismo programa sugiere importar */
import com.cafechul.demo.entity.TipoCafe;
import com.cafechul.demo.repository.TipoCafeRepository;
import com.cafechul.demo.service.TipoCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/tiposDeCafe")
public class TipoCafeController {
    @Autowired
    private TipoCafeService tipoCafeService;

    @GetMapping
    public ResponseEntity<List<TipoCafe>> findAllTipoCafe() {
        List<TipoCafe> tipoCafe = tipoCafeService.tipoCafefindAll();
        return ResponseEntity.ok(tipoCafe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoCafeById(@PathVariable Long id) {
        TipoCafe tipoCafe = tipoCafeService.tipoCafeFindById(id);
        if (tipoCafe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(tipoCafe);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTipoCafe(@PathVariable Long id, @RequestBody TipoCafe tipoCafe) {
        TipoCafe tipoCafeToUpdate = tipoCafeService.tipoCafeUpdate(id, tipoCafe);
        if (tipoCafeToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(tipoCafeToUpdate);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoCafe(@PathVariable Long id){
        tipoCafeService.tipoCafeDelete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> saveTipoCafe(@RequestBody TipoCafe tipoCafe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCafeService.tipoCafeSave(tipoCafe));
    }




}
