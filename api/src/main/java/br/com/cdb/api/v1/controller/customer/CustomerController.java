package br.com.cdb.api.v1.controller.customer;

import br.com.cdb.core.model.customer.Customer;
import br.com.cdb.core.model.customer.CustomerDTO;
import br.com.cdb.core.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Customer> listAll(Pageable pageable) {
        return service.listAll(pageable);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getById(customerId));
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CustomerDTO dto) {
        Long newCustomerId = service.create(dto);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{customerId}")
                .buildAndExpand(newCustomerId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long customerId, @RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(service.update(customerId, dto));
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long customerId) {
        service.delete(customerId);
    }

}
