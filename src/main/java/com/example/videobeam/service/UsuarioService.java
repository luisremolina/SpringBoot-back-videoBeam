package com.example.videobeam.service;

import com.example.videobeam.entity.Usuario;
import com.example.videobeam.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public void createUsuario(Usuario usuario){
         usuarioRepository.save(usuario);
    }

    public Optional<Usuario> getByCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }

    public boolean existsByCorreo(String correo){
        return usuarioRepository.existsByCorreo(correo);
    }

}
