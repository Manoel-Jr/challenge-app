package challengeclient.com.br.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challengeclient.com.br.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public boolean existsByCpf(String cpf);
	Page<Cliente> findAll(Pageable page);
}
