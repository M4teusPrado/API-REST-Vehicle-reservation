package com.example.vehiclereservation.service;

import java.util.List;
import java.util.Optional;

import com.example.vehiclereservation.model.Client;
import com.example.vehiclereservation.repository.RepositoryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceClient {

    @Autowired
    private RepositoryClient repositoryClient;

	public Client saveClient(Client client) {
        
        return repositoryClient.saveClient(client);
	}

	public List<Client> getAllClients() {
		return repositoryClient.getAllClients();
	}

	public Client getClientByCode(int code) {
        
        Optional<Client> opClient = repositoryClient.getClientByCode(code);
        return opClient.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado!"));
	}    
}