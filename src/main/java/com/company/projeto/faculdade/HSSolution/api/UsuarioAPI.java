package com.company.projeto.faculdade.HSSolution.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.company.projeto.faculdade.HSSolution.facade.UsuarioFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.company.projeto.faculdade.HSSolution.dto.UsuarioDTO;

import java.util.List;


@Controller
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "teste")
public class UsuarioAPI {


    @Autowired
    private UsuarioFacade usuariosFacade;

    @ApiOperation(value = "Retorna todos usuarios")
    @GetMapping
    @ResponseBody
    public List<UsuarioDTO> getAll(){
        return usuariosFacade.getAll();
    }

    @GetMapping("/{idUsuario}")
    @ResponseBody
    public UsuarioDTO getById(@PathVariable("idUsuario") Long idUsuario){
        return usuariosFacade.getById(idUsuario);
    }

    @PostMapping
    @ResponseBody
    public UsuarioDTO criar(@RequestBody UsuarioDTO usuarioDTO){
        return usuariosFacade.criar(usuarioDTO);
    }

    @PutMapping("/{idUsuario}")
    @ResponseBody
    public UsuarioDTO atualizar(@PathVariable("idUsuario") Long idUsuario,
                                @RequestBody UsuarioDTO usuarioDTO){
        return usuariosFacade.atualizar(usuarioDTO,idUsuario);
    }

    @DeleteMapping("/{idUsuario}")
    @ResponseBody
    public String deletar(@PathVariable("idUsuario") Long idUsuario){
        return usuariosFacade.delete(idUsuario);
    }

}
