package br.com.mp.algafood;

import br.com.mp.algafood.di.notificacao.NotificadorEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgaConfig {

    @Bean
    public NotificadorEmail notificadorEmail() {
        NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
        notificador.setCaixaAlta(true);

        return notificador;
    }

//    @Bean
//    public AtivacaoClienteService ativacaoClienteService() {
//        return new AtivacaoClienteService(notificadorEmail());
//    }

}