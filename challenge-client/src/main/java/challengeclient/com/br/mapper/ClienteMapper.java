package challengeclient.com.br.mapper;

import challengeclient.com.br.model.dto.ClienteDTO;
import challengeclient.com.br.model.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapper {
	
	private final ModelMapper modelMapper;

	public Cliente dtoToEntity(ClienteDTO dto) {
		return  modelMapper.map(dto, Cliente.class);
	}
	
	public ClienteDTO entityToDto(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDTO.class);
	}
}
