package com.company.projeto.faculdade.HSSolution.facade;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AutenticacaoFacade {
    
    //Lista de usuários
    private static final Map<String, String> USUARIOS_VALIDOS = new HashMap<>();
    static {
        USUARIOS_VALIDOS.put("samuel", "123");
        USUARIOS_VALIDOS.put("humberto", "1234");
        USUARIOS_VALIDOS.put("felipe", "12345");
    }

    public boolean autenticar(String login, String senha) {
        String senhaValida = USUARIOS_VALIDOS.get(login);
        return senhaValida != null && senhaValida.equals(senha);
    }

}
