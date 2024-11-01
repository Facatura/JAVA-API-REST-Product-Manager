package com.cafechul.demo.controller;
/* cosas necesarias que el mismo programa sugiere importar */
import com.cafechul.demo.entity.Producto;
import com.cafechul.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> findAllProductos() {
        return ResponseEntity.ok(productoService.productofindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Long id) {
        Producto producto = productoService.productoFindById(id);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(producto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoToUpdate = productoService.productoUpdate(id, producto);
        if (productoToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(productoToUpdate);
        }
    }

        @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        productoService.productoDelete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.productoSave(producto));
    }




}
