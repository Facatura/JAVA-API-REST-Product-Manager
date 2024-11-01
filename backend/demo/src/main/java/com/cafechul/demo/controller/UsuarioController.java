package com.cafechul.demo.controller;
/* cosas necesarias que el mismo programa sugiere importar */
import com.cafechul.demo.entity.Usuario;
import com.cafechul.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> findAllUsuarios() {
        return ResponseEntity.ok(usuarioService.usuariofindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.usuarioFindById(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
        usuarioService.usuarioDelete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.usuarioSave(usuario));
    }




}

