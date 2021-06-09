package br.com.mp.algafood.di.notificacao;

import br.com.mp.algafood.di.modelo.Cliente;

public interface Notificador {

    void notificar(Cliente cliente, String mensagem);

}
