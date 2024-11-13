package com.paulo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.domain.Cliente;
import com.paulo.usecase.BuscarCliente;
import com.paulo.usecase.CadastrarCliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	private BuscarCliente buscarCliente;
	private CadastrarCliente cadastraCliente;
	
	@Autowired
	public ClienteResource(BuscarCliente buscarCliente, CadastrarCliente cadastraCliente) {
		this.buscarCliente = buscarCliente;
		this.cadastraCliente = cadastraCliente;
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> buscar(Pageable pageable) {
		return ResponseEntity.ok(buscarCliente.buscar(pageable));
	}
	
	@GetMapping(value = "/${id}")
	@Operation(summary = "Buscar um cliente pelo id")
	public ResponseEntity<Cliente> buscarporId(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscarCliente.buscarPorId(id));
	}
	
	@GetMapping(value = "isCadastrado/{id}")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscarCliente.isCadastrado(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastraCliente.cadastrar(cliente));
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	@Operation(summary = "Buscar um cliente pelo cpf")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value = "cpf", required = true) Long cpf) {
		return ResponseEntity.ok(buscarCliente.buscarPorCpf(cpf));
	}
	
	@PutMapping
	@Operation(summary = "Atualizar um cliente")
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastraCliente.atualizar(cliente));
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um cliente pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
		cadastraCliente.remove(id);
		return ResponseEntity.ok("Removido com sucesso!");
	}
}
