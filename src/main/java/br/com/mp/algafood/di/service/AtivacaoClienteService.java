package br.com.mp.algafood.di.service;

import br.com.mp.algafood.di.modelo.Cliente;
import br.com.mp.algafood.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private Notificador notificador;

//    @Autowired
//    public AtivacaoClienteService(Notificador notificador) {
//        this.notificador = notificador;
//
//        System.out.println("AtivacaoClienteService: " + notificador);
//    }

    //Apenas como exemplo: Se tiver um construtor, o Spring não sabe, qual instânciar, para isso, utilize @Autowired
//    public AtivacaoClienteService(String teste) {
//
//    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }

//    @Autowired
//    public void setNotificador(Notificador notificador) {
//        this.notificador = notificador;
//    }
}