package ru.jakimenko.skymeal.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import ru.jakimenko.skymeal.AuthorizedUser;
import ru.jakimenko.skymeal.to.UserTo;
import ru.jakimenko.skymeal.web.user.AbstractUserController;

import javax.validation.Valid;

/**
 * Created by konst on 06.05.17.
 */
@Controller
public class RootController { // extends AbstractUserController

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:planes";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/planes", method = RequestMethod.GET)
    public String planes() {
        return "planes";
    }

}
