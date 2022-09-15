package ru.kata.rest_template;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kata.rest_template.model.User;
import ru.kata.rest_template.service.UserService;

import static org.springframework.http.HttpHeaders.SET_COOKIE;

@SpringBootApplication
public class RestTemplateApplication {
    private final UserService userService;

    public RestTemplateApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return (args) -> {
            String cookie = userService.getAllUsers().getHeaders().get(SET_COOKIE).get(0).split(";")[0];
            userService.setCookies(cookie);

            String add = userService.createUser(new User(3L, "James", "Brown", (byte) 23)).getBody().toString();
            String edit = userService.editUser(new User(3L, "Thomas", "Shelby", (byte) 23)).getBody().toString();
            String delete = userService.deleteUser(3L).getBody().toString();

            System.out.format("%s%s%s", add, edit, delete);
        };
    }

}