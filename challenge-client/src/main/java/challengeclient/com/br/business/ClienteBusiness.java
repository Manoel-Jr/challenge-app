package challengeclient.com.br.business;

import challengeclient.com.br.mapper.ClienteMapper;
import challengeclient.com.br.model.dto.ClienteDTO;
import challengeclient.com.br.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteBusiness {

    private final ClienteMapper clienteMapper;
    private final ClienteService clienteService;

    public ClienteDTO create(ClienteDTO dto) {
        return clienteMapper.entityToDto(clienteService.cadastrar(clienteMapper.dtoToEntity(dto)));
    }

    public ClienteDTO update(ClienteDTO dto, Long id) {
        return clienteMapper.entityToDto(clienteService.atualizar(clienteMapper.dtoToEntity(dto), id));
    }

    public ClienteDTO getOne(Long id) {
        return clienteMapper.entityToDto(clienteService.buscarPorId(id));
    }

    public List<ClienteDTO> findAll(Pageable page) {
        return clienteService.listarTodos(page).stream().map(clienteMapper::entityToDto).collect(Collectors.toList());
    }

    public void delete(Long id) {
        clienteService.remove(id);
    }
}
