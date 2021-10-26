package br.com.joelma.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.joelma.model.Usuario;
import br.com.joelma.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {


@Autowired
private  UsuarioService service;

//vai buscar por id mas poderia ser uma busca por qualquer atributo 
@GetMapping(value= "/{id}")
public ResponseEntity<Usuario> findById(@PathVariable Long id){
      Usuario obj = this.service.findById(id);
	return ResponseEntity.ok().body(obj);
}	


@GetMapping("/todos")
public ResponseEntity<List<Usuario>>findAll(){
	List<Usuario>list= service.findByAll();
	return ResponseEntity.ok().body(list);
	}

@PutMapping(value = "atualizar/{id}")
public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario obj){
	Usuario newObj = service.update(id, obj);
	return ResponseEntity.ok().body(newObj);
	}

@PostMapping("/salvar")
public ResponseEntity<Usuario>create (@RequestBody Usuario obj){
	Usuario newObj=service.create(obj);
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
	return ResponseEntity.created(uri).build();
}


@DeleteMapping("/deletar/{id_usuario}")
public ResponseEntity<Void> delete(@PathVariable Long id){
	service.delete(id);
	return ResponseEntity.noContent().build();
}
}