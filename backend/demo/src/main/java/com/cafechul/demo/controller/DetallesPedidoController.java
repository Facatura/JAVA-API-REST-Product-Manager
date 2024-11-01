package com.cafechul.demo.controller;
/* cosas necesarias que el mismo programa sugiere importar */
import com.cafechul.demo.entity.DetallesPedido;
import com.cafechul.demo.entity.TipoCafe;
import com.cafechul.demo.service.DetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/detallesPedidos")
public class DetallesPedidoController {
    @Autowired
    private DetallesPedidoService detallesPedidoService;

    @GetMapping
    public ResponseEntity<?> findAllDetallesPedido() {
        return ResponseEntity.ok(detallesPedidoService.detallesPedidofindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetallesPedidoById(@PathVariable Long id) {
        DetallesPedido detallesPedido = detallesPedidoService.detallesPedidoFindById(id);
        if (detallesPedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(detallesPedido);
        }
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetallesPedido(@PathVariable Long id){
        detallesPedidoService.detallesPedidoDelete(id);
        return ResponseEntity.ok().build();
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetallesPedido(@PathVariable Long id, @RequestBody DetallesPedido detallesPedido) {
        DetallesPedido detallesPedidoToUpdate = detallesPedidoService.detallesPedidoUpdate(id, detallesPedido);
        if (detallesPedidoToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(detallesPedidoToUpdate);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveDetallesPedido(@RequestBody DetallesPedido detallesPedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detallesPedidoService.detallesPedidoSave(detallesPedido));
    }




}

