package com.paulo.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.paulo.domain.Cliente;
import com.paulo.repository.IClienteRepository;

import jakarta.validation.Valid;

public class CadastrarCliente {

	private IClienteRepository clienteRepository;
	
	@Autowired
	public CadastrarCliente(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrar(@Valid Cliente cliente) {
		return  this.clienteRepository.insert(cliente);
	}
	
	public Cliente atualizar(@Valid Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public void remove(String id) {
		this.clienteRepository.deleteById(id);
	}
}
