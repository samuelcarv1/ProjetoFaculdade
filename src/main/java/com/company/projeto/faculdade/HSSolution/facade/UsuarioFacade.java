package com.company.projeto.faculdade.HSSolution.facade;

import com.company.projeto.faculdade.HSSolution.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioFacade {

    private static final Map<Long, UsuarioDTO> usuarios = new HashMap();

    public UsuarioDTO criar(UsuarioDTO usuarioDTO){
        Long proximoId = usuarios.keySet().size() + 1L;
        usuarioDTO.setIdUsuario(proximoId);
        usuarios.put(proximoId,usuarioDTO);
        return usuarioDTO;
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO, Long usuarioId){
        usuarios.put(usuarioId,usuarioDTO);
        return usuarioDTO;
    }

    public UsuarioDTO getById(Long usuarioId){
        return usuarios.get(usuarioId);
    }

    public List<UsuarioDTO> getAll(){
        return new ArrayList<>(usuarios.values());
    }

    public String delete(Long usuarioId){
        usuarios.remove(usuarioId);
        return "Usúario deletado com sucesso!";
    }

}
