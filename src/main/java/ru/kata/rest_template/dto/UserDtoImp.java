package ru.kata.rest_template.dto;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kata.rest_template.model.User;

import java.util.List;

import static org.springframework.http.HttpHeaders.*;

@Component
public class UserDtoImp implements UserDto {
    private static final String URL_API = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders httpHeaders = new HttpHeaders();


    public ResponseEntity createUser(User user) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        return restTemplate.postForEntity(URL_API, new HttpEntity<User>(user, httpHeaders), String.class);
    }

    public ResponseEntity<List<User>> getAllUsers() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        return restTemplate.exchange(
                URL_API,
                HttpMethod.GET,
                new HttpEntity<User>(httpHeaders),
                new ParameterizedTypeReference<List<User>>() {
                });
    }

    public ResponseEntity editUser(User user) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        return restTemplate.exchange(URL_API, HttpMethod.PUT, new HttpEntity<User>(user, httpHeaders), String.class);
    }

    public ResponseEntity deleteUser(Long id) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        return restTemplate.exchange(
                String.format("%s/%s", URL_API, id),
                HttpMethod.DELETE,
                new HttpEntity<User>(httpHeaders),
                String.class);
    }

    public void setCookies(String cookie) {
        httpHeaders.add(COOKIE, cookie);
    }

}
