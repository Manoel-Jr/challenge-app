package challengeclient.com.br.service;

import challengeclient.com.br.model.entity.Cliente;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

	public Cliente cadastrar(Cliente dto);
	
	public Cliente buscarPorId(Long id);
	
	public void remove(Long id);
	
	public Cliente atualizar(Cliente dto, Long id);
	
	public List<Cliente> listarTodos(Pageable page);
}
