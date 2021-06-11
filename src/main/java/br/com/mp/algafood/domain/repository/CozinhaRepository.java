package br.com.mp.algafood.domain.repository;

import br.com.mp.algafood.domain.Cozinha;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha adicionar(Cozinha cozinha);
    void remover(Cozinha cozinha);
}
