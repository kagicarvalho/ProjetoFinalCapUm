package com.bearsystems.bsCustomer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bearsystems.bsCustomer.dto.ClientDTO;
import com.bearsystems.bsCustomer.entities.Client;
import com.bearsystems.bsCustomer.repositories.ClientRepository;
import com.bearsystems.bsCustomer.service.exceptions.DatabaseException;
import com.bearsystems.bsCustomer.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(c -> new ClientDTO(c)).collect(Collectors.toList());
	}
		
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){		
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(c -> new ClientDTO(c));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado"));
		
		return new ClientDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public ClientDTO insert(ClientDTO clientDTO) {
		
		Client entity = new Client();
		copyDtoToEntity(clientDTO, entity);
		
		entity = repository.save(entity);
		
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO clientDTO) {
		
		try {
			Client entity = repository.getOne(id);
			copyDtoToEntity(clientDTO, entity);
			
			entity = repository.save(entity);
			
			return new ClientDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id: " + id + " não encontrado ");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id: " + id + " não encontrado ");
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Não foi possivel remover cliente, ele possui dados diversos no sistema");
		}
	}
	
	private void copyDtoToEntity(ClientDTO clientDTO, Client entity) {
		entity.setName(clientDTO.getName());
		entity.setCpf(clientDTO.getCpf());
		entity.setIncome(clientDTO.getIncome());
		entity.setBirthDate(clientDTO.getBirthDate());
		entity.setChildren(clientDTO.getChildren());
	}
}
