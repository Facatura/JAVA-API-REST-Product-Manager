package com.cafechul.demo.service;

import java.util.List;

import com.cafechul.demo.entity.TipoCafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafechul.demo.entity.Usuario;
import com.cafechul.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    //findAll

    public List<Usuario> usuariofindAll(){
        return usuarioRepository.findAll();
    }

    //findById
    public Usuario usuarioFindById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    //save
    public Usuario usuarioSave(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //update
    public Usuario usuarioUpdate(Long id, Usuario usuario){
        Usuario usuarioToUpdate = usuarioFindById(id);
        if(usuarioToUpdate == null){
            usuarioToUpdate.setNombre(usuario.getNombre());
            usuarioToUpdate.setApellido(usuario.getApellido());
            usuarioToUpdate.setCorreo(usuario.getCorreo());
            usuarioToUpdate.setContrasenia(usuario.getContrasenia());
            usuarioToUpdate.setDireccion(usuario.getDireccion());
            return null;
        }else {
            return usuarioToUpdate;
        }
    }


    // delete
    public void usuarioDelete(Long id){
        Usuario usuarioToDelete = usuarioFindById(id);
        if(usuarioToDelete != null){
            usuarioRepository.deleteById(id);
        }
    }
}
