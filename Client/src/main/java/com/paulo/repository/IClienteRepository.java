package com.paulo.repository;


import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paulo.domain.Cliente;

@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String>{
	
	Optional<Cliente> findByCpf(Long cpf);
}
