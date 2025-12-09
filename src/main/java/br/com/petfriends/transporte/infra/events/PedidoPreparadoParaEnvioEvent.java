package br.com.petfriends.transporte.infra.events;

public record PedidoPreparadoParaEnvioEvent(
    String pedidoId,
    String nomeDestinatario,
    EnderecoDTO enderecoEntrega
) {
    public record EnderecoDTO(
        String rua,
        String numero,
        String cep,
        String cidade,
        String estado
    ) {}
}
