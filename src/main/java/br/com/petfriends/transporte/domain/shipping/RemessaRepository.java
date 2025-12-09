package br.com.petfriends.transporte.domain.shipping;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemessaRepository extends JpaRepository<Remessa, Long> {
    Optional<Remessa> findByPedidoId(String pedidoId);
}
