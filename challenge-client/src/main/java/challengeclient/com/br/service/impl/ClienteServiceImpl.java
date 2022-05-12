package challengeclient.com.br.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import challengeclient.com.br.exception.ClienteExistenteException;
import challengeclient.com.br.exception.ClienteNotFoundException;
import challengeclient.com.br.model.entity.Cliente;
import challengeclient.com.br.repository.ClienteRepository;
import challengeclient.com.br.service.ClienteService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente cadastrar(Cliente cliente) {
    	valid(cliente);
    	return clienteRepository.saveAndFlush(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
    	return clienteRepository.findById(id).orElseThrow(ClienteNotFoundException::new);
    }

    @Override
    public void remove(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente atualizar(Cliente cliente, Long id) {
        Cliente clienteSalvo = this.buscarPorId(id);
        BeanUtils.copyProperties(cliente, clienteSalvo, "id");
        return clienteRepository.saveAndFlush(clienteSalvo);
    }

    @Override
    public List<Cliente> listarTodos(Pageable page) {
        return clienteRepository.findAll(page).getContent();
    }
    
    private void valid(Cliente cliente) {
		if(clienteRepository.existsByCpf(cliente.getCpf())) {  
    	    throw new ClienteExistenteException();
    	}
	}
}
