package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.modal.Estado;
import com.dev.backend.service.EstadoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping ("api/estado")

public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping ("/todos")
    public List<Estado> buscarTodos (){
        return estadoService.buscarTodos();
    }
    
    @PostMapping ("/inserir")
    public Estado inserir (@RequestBody Estado estado){
        return estadoService.inserir(estado);
    }

    @PostMapping ("/alterar")
    public Estado alterar (@RequestBody Estado estado){
        return estadoService.alterar(estado);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir (@PathParam("id") Long id){
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
    }
    
}
