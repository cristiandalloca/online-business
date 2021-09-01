package br.com.cdb.core.service;

import br.com.cdb.core.exception.UserNotFoundException;
import br.com.cdb.core.model.user.User;
import br.com.cdb.core.model.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<User> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Long create(User user) {
        return repository.save(user).getId();
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return this.findById(id);
    }

    private User findById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
