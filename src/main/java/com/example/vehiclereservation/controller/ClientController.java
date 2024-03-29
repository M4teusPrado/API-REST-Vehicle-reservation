package com.example.vehiclereservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.vehiclereservation.DTO.UpdateOrSaves.ClientDTO;
import com.example.vehiclereservation.DTO.UpdateOrSaves.ReservationDTO;
import com.example.vehiclereservation.model.Client;
import com.example.vehiclereservation.model.Reservation;
import com.example.vehiclereservation.service.ServiceClient;
import com.example.vehiclereservation.service.ServiceReservation;

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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ServiceClient serviceClient;

    @Autowired
    private ServiceReservation serviceReservation;

    @PostMapping()
    public ResponseEntity<Client> saveClient(@Valid @RequestBody ClientDTO clientDTO, HttpServletRequest request, UriComponentsBuilder builder)
    {
        Client client = serviceClient.saveClient(clientDTO);
     
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + client.getCode()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping()
    public List<Client> getAllCLients() 
    {
        return serviceClient.getAllClients();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Client> getClientByCode(@PathVariable int code)
    {
        return ResponseEntity.ok(serviceClient.getClientByCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<Client> updateClient(@PathVariable int code, @Valid @RequestBody ClientDTO clientDTO)
    {
        return ResponseEntity.ok(serviceClient.updateDTO(code, clientDTO));
    }

    @PostMapping("/{codeClient}/veiculos/{codeVehicle}")
    public ResponseEntity<Reservation> saveReservation(
                                                        @PathVariable int codeClient, @PathVariable int codeVehicle, @Valid @RequestBody ReservationDTO reservationDTO,
                                                        HttpServletRequest request, UriComponentsBuilder builder
                                                       )
    {
        Reservation reservation = serviceReservation.save(codeClient, codeVehicle, reservationDTO);
        
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + reservation.getCode()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClient(@PathVariable int code){
        serviceClient.deleteClient(code);
        return ResponseEntity.noContent().build();
    }
}
