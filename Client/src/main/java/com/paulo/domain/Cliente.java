package com.paulo.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collation = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "cliente", description = "cliente")
public class Cliente {

	@Id
	@Schema(description = "Identificador único")
	private String id;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
	private String nome;
	
	@NotNull
	@Size(min = 1, max = 11)
	@Schema(description = "CPF", minLength = 1, maxLength = 11, nullable = false)
	private Long cpf;
	
	@NotNull
	@Size(min = 1, max = 11)
	@Schema(description = "Telefone", minLength = 1, maxLength = 11, nullable = false)
	private Long tel;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Indexed(unique = true, background = true)
	@Schema(description = "E-mail", minLength = 1, maxLength = 50, nullable = false)
	@Pattern(regexp = "@+.", message = "E-mail inválido")
	private String email;
	
}
