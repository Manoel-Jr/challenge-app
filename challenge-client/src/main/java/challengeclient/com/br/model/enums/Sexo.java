package challengeclient.com.br.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {

	MASCULINO(1, "MASCULINO"), FEMININO(2, "FEMININO");

	private Integer codigo;
	private String descricao;

	public static Sexo ToEnum(Integer cod) {
		for (Sexo sexo : Sexo.values()) {
			if (cod.equals(sexo.getCodigo())) {
				return sexo;
			}
		}
		throw new IllegalArgumentException("Sexo Invalido!");
	}

}
