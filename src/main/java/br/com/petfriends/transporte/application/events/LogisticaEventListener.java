package br.com.petfriends.transporte.application.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.petfriends.transporte.infra.events.PedidoPreparadoParaEnvioEvent;

@Component
public class LogisticaEventListener {

    private static final Logger logger = LoggerFactory.getLogger(LogisticaEventListener.class);

    @EventListener
    public void handle(PedidoPreparadoParaEnvioEvent event) {
        logger.info("Solicitação de entrega recebida para PedidoID: {}", event.pedidoId());

        logger.info("Destino: {}, {} - {}",
            event.enderecoEntrega().rua(),
            event.enderecoEntrega().cidade(),
            event.enderecoEntrega().estado()
        );
    }
}
