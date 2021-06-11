package br.com.mp.algafood.jpa;

import br.com.mp.algafood.AlgafoodApiApplication;
import br.com.mp.algafood.domain.Cozinha;
import br.com.mp.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class InclusaoCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE).run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinhaBrasileira = new Cozinha();
        cozinhaBrasileira.setNome("Brasileira");

        Cozinha cozinhaMexicana = new Cozinha();
        cozinhaMexicana.setNome("Mexicana");

        cozinhaRepository.adicionar(cozinhaBrasileira);
        cozinhaRepository.adicionar(cozinhaMexicana);


        List<Cozinha> cozinhas = cozinhaRepository.listar();

        cozinhas.forEach(cozinha -> {
            System.out.println(cozinha.getNome());
        });

    }
}
