package br.com.cdb.core.service;

import br.com.cdb.core.exception.CustomerNotFoundException;
import br.com.cdb.core.model.customer.Customer;
import br.com.cdb.core.model.customer.CustomerDTO;
import br.com.cdb.core.model.customer.CustomerPhone;
import br.com.cdb.core.model.customer.CustomerPhoneDTO;
import br.com.cdb.core.model.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Long create(CustomerDTO dto) {
        return repository.save(convertToEntity(dto)).getId();
    }

    @Transactional(readOnly = true)
    public Page<Customer> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public CustomerDTO getById(Long id) {
        return convertToDto(this.findById(id));
    }

    @Transactional
    public CustomerDTO update(Long id, CustomerDTO dto) {
        Customer customer = this.findById(id);
        updateFromCustomerDTO(customer, dto);
        return convertToDto(repository.save(customer));
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(this.findById(id));
    }

    private void updateFromCustomerDTO(Customer customer, CustomerDTO dto) {
        customer.setName(dto.getName());
        customer.setBirthday(dto.getBirthday());
        customer.setEmail(dto.getEmail());
        customer.setType(dto.getType());
        customer.setPhones(dto.getPhones().stream().map(this::convertToEntity).collect(Collectors.toSet()));
    }


    private Customer findById(Long id) {
        return repository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    private Customer convertToEntity(CustomerDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }

    private CustomerDTO convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private CustomerPhone convertToEntity(CustomerPhoneDTO dto) {
        return modelMapper.map(dto, CustomerPhone.class);
    }
}
