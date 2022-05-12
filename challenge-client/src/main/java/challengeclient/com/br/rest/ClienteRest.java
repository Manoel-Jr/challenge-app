package challengeclient.com.br.rest;

import challengeclient.com.br.business.ClienteBusiness;
import challengeclient.com.br.model.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteRest {

	private final ClienteBusiness business;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteDTO dto) {
		return new ResponseEntity<>(business.create(dto), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
		return new ResponseEntity<>(business.getOne(id), HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Long id) {
		business.delete(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteDTO>> listaTodos(Pageable page) {
		return new ResponseEntity<>(business.findAll(page), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable("id") Long id, @RequestBody ClienteDTO dto) {
		return new ResponseEntity<>(business.update(dto, id), HttpStatus.OK);
	}
}
