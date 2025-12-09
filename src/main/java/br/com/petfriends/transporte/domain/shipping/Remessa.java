package br.com.petfriends.transporte.domain.shipping;

import java.time.LocalDateTime;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Remessa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pedidoId;

    @Embedded
    private StatusRemessa status;

    private LocalDateTime dataDespacho;

    public Remessa(String pedidoId) {
        this.pedidoId = pedidoId;
        this.status = new StatusRemessa(StatusRemessa.Tipo.EM_TRANSITO);
        this.dataDespacho = LocalDateTime.now();
    }

    public void registrarEntrega() {
        this.status = new StatusRemessa(StatusRemessa.Tipo.ENTREGUE);
    }
}
