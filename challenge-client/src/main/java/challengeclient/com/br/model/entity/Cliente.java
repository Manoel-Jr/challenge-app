package challengeclient.com.br.model.entity;

import challengeclient.com.br.model.enums.Sexo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Embedded
	private Endereco endereco;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo")
	private Sexo sexo;
}


