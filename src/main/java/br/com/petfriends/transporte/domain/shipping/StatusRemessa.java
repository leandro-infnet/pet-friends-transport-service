package br.com.petfriends.transporte.domain.shipping;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
public class StatusRemessa implements Serializable {

    public enum Tipo {
        EM_TRANSITO, ENTREGUE, DEVOLVIDO, EXTRAVIADO
    }

    @Enumerated(EnumType.STRING)
    private final Tipo codigo;

    private final LocalDateTime dataAtualizacao;

    public StatusRemessa(Tipo codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("O status da remessa é obrigatório");
        }
        this.codigo = codigo;
        this.dataAtualizacao = LocalDateTime.now();
    }
}
