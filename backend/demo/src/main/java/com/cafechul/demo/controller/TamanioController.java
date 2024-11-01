package com.cafechul.demo.controller;
/* cosas necesarias que el mismo programa sugiere importar */
import com.cafechul.demo.entity.Tamanio;
import com.cafechul.demo.service.TamanioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/tamanios")
public class TamanioController {
    @Autowired
    private TamanioService tamanioService;

    @GetMapping
    public ResponseEntity<?> findAllTamanios() {
        return ResponseEntity.ok(tamanioService.tamaniofindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTamanioById(@PathVariable Long id) {
        Tamanio tamanio = tamanioService.tamanioFindById(id);
        if (tamanio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(tamanio);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTamanio(@PathVariable Long id, @RequestBody Tamanio tamanio) {
        Tamanio tamanioToUpdate = tamanioService.tamanioUpdate(id, tamanio);
        if (tamanioToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(tamanioToUpdate);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTamanios(@PathVariable Long id){
        tamanioService.tamanioDelete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> saveTamanios(@RequestBody Tamanio tamanio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tamanioService.tamanioSave(tamanio));
    }




}
