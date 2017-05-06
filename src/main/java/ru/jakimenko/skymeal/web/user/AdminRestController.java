package ru.jakimenko.skymeal.web.user;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.jakimenko.skymeal.model.User;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
@RestController
@RequestMapping(AdminRestController.REST_URL)
public class AdminRestController extends AbstractUserController {
    static final String REST_URL = "/rest/admin/users";

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createWithLocation(@Valid @RequestBody User user) {
        User created = super.create(user);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(uriOfNewResource);

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody User user, @PathVariable("id") int id) {
        super.update(user, id);
    }

    @RequestMapping(value = "/by", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByMail(@RequestParam("email") String email) {
        return super.getByMail(email);
    }
}