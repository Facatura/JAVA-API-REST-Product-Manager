package com.cafechul.demo.controller;
/* cosas necesarias que el mismo programa sugiere importar */
import com.cafechul.demo.entity.Pedido;
import com.cafechul.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<?> findAllPedido() {
        return ResponseEntity.ok(pedidoService.pedidofindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> gePedidoById(@PathVariable Long id) {
        Pedido pedido = pedidoService.pedidoFindById(id);
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(pedido);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido pedidoToUpdate = pedidoService.pedidoUpdate(id, pedido);
        if (pedidoToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(pedidoToUpdate);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id){
        pedidoService.pedidoDelete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> savePedido(@RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.pedidoSave(pedido));
    }




}
