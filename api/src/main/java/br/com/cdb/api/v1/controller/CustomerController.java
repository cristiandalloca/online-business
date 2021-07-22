package br.com.cdb.api.v1.controller;

import br.com.cdb.core.model.customer.CustomerDTO;
import br.com.cdb.core.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CustomerDTO dto) {
        service.create(dto);
        return ResponseEntity.ok().build();
    }

}
