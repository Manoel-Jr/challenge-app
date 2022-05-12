package challengeclient.com.br.model.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

	private String cep;

	private String rua;

	private String numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String uf;
}
