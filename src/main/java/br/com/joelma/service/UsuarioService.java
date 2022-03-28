package br.com.joelma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.joelma.model.Usuario;
import br.com.joelma.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario findById(Long id) {
	Optional<Usuario> obj = repository.findById(id);
	return obj.orElse(null);
}

	public List<Usuario> findByAll() {
		return repository.findAll();
	}

	public Usuario update(Long id, Usuario obj) {
		Usuario newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setCPF(obj.getCPF());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefone(obj.getTelefone());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);
	}
	public Usuario create(Usuario obj) {
		
		obj.setId(null);
		return repository.save(obj);
		
		
	}
	public void delete (Long id){
		findById(id);
		repository.deleteById(id);
		
	}
	}
	