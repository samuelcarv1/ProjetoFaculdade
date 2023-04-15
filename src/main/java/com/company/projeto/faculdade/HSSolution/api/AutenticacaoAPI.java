package com.company.projeto.faculdade.HSSolution.api;

import com.company.projeto.faculdade.HSSolution.dto.AutenticacaoDTO;
import com.company.projeto.faculdade.HSSolution.facade.AutenticacaoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AutenticacaoAPI {
    @Autowired
    private AutenticacaoFacade autenticacaoFacade;

    @PostMapping(value = "/autenticacao", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean autenticar(@RequestBody AutenticacaoDTO autenticacaoDTO){
        return autenticacaoFacade.autenticar(autenticacaoDTO.getLogin(),autenticacaoDTO.getSenha());
    }
}
