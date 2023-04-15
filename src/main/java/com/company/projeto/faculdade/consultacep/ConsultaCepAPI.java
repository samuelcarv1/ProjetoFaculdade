package com.company.projeto.faculdade.consultacep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("consulta-cep")
public class ConsultaCepAPI {
    
    @GetMapping("{cep}")
    public CepResultDTO consultaCep(@PathVariable("cep") String cep) throws Exception {

        try{
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            ResponseEntity<CepResultDTO> resp = restTemplate.getForEntity(url,CepResultDTO.class);

            return resp.getBody();
        }catch(Exception e) {
            throw new Exception("Não foi possível realizar a consulta de CEP. Por favor, verifique se o CEP está correto e tente novamente.");
        }
    }
}
