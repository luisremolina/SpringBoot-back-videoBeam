package com.example.videobeam.controller;


import com.example.videobeam.dto.Mensaje;
import com.example.videobeam.entity.Usuario;
import com.example.videobeam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/hi")
    public ResponseEntity<String> saludo(){
        return new ResponseEntity(new Mensaje("Hola mundo since message"), HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> lista = usuarioService.findAllUsuarios();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        System.out.println(usuario.toString());
        usuarioService.createUsuario(usuario);
        return new ResponseEntity(new Mensaje("Usuario Creado Correctamente"), HttpStatus.OK);
    }

}
