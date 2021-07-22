package br.com.cdb.core.service;

import br.com.cdb.core.model.customer.Customer;
import br.com.cdb.core.model.customer.CustomerDTO;
import br.com.cdb.core.model.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void create(CustomerDTO dto) {
        repository.save(convertToEntity(dto));
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> listAll() {
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Customer convertToEntity(CustomerDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }

    private CustomerDTO convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
}
