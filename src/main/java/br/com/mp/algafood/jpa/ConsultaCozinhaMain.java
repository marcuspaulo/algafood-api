package br.com.mp.algafood.jpa;

import br.com.mp.algafood.AlgafoodApiApplication;
import br.com.mp.algafood.domain.Cozinha;
import br.com.mp.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE).run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        List<Cozinha> cozinhas = cozinhaRepository.listar();

        cozinhas.forEach(cozinha -> {
            System.out.println(cozinha.getNome());
        });

    }
}
