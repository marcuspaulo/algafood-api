package br.com.mp.algafood.domain.repository;

import br.com.mp.algafood.domain.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante adicionar(Restaurante cozinha);
    void remover(Restaurante cozinha);
}
