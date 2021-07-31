package br.com.cdb.core.enviroment;

import br.com.cdb.core.model.user.User;

public class UsersEnviroment {

    public static User userMaria() {
        User user = new User();
        user.setName("Maria");
        user.setCpf("93371107094");
        user.setEmail("maria@gmail.com");
        user.setPassword("123");

        return user;
    }
}
