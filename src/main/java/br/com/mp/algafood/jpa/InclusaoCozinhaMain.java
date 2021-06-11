package br.com.mp.algafood.jpa;

import br.com.mp.algafood.AlgafoodApiApplication;
import br.com.mp.algafood.domain.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class InclusaoCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE).run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinhaBrasileira = new Cozinha();
        cozinhaBrasileira.setNome("Brasileira");

        Cozinha cozinhaMexicana = new Cozinha();
        cozinhaMexicana.setNome("Mexicana");

        cadastroCozinha.adicionar(cozinhaBrasileira);
        cadastroCozinha.adicionar(cozinhaMexicana);


        List<Cozinha> cozinhas = cadastroCozinha.listar();

        cozinhas.forEach(cozinha -> {
            System.out.println(cozinha.getNome());
        });

    }
}
