package challengeclient.com.br.model.dto;

import challengeclient.com.br.model.enums.Sexo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ClienteDTO implements Serializable {

	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private EnderecoDTO endereco;
	private Sexo sexo;
}
