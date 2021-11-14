package br.com.cdb.api.v1.controller.user;

import br.com.cdb.core.model.user.User;
import br.com.cdb.core.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;

    public UserController(UserService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public Page<UserResponseDto> listAll(Pageable pageable) {
        Page<User> users = service.listAll(pageable);
        if (users.isEmpty()) {
            return Page.empty();
        }
        List<UserResponseDto> dtos = users.getContent()
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, users.getTotalElements());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long userId) {
        return ResponseEntity.ok(converToDto(service.getById(userId)));
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody UserRequestDto request) {
        Long newUser = service.create(convertToEntity(request));
        final URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{userId}")
                .buildAndExpand(newUser)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    private UserResponseDto converToDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    private User convertToEntity(UserRequestDto dto) {
        return modelMapper.map(dto, User.class);
    }
}
