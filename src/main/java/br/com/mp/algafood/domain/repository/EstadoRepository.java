package br.com.mp.algafood.domain.repository;

import br.com.mp.algafood.domain.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);
}
