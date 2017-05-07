package ru.jakimenko.skymeal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jakimenko.skymeal.web.user.AbstractUserController;

/**
 * Created by konst on 06.05.17.
 */
@Controller
public class RootController extends AbstractUserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }

    @RequestMapping(value = "/planes", method = RequestMethod.GET)
    public String planes() {
        return "planes";
    }

//    @RequestMapping(value = "/main", method = RequestMethod.GET)
//    public String main() {
//        return "main";
//    }
//
//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public String profile() {
//        return "profile";
//    }
//
//    @RequestMapping(value = "/profile", method = RequestMethod.POST)
//    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
//        if (!result.hasErrors()) {
//            try {
//                userTo.setId(AuthorizedUser.id());
//                super.update(userTo);
//                AuthorizedUser.get().update(userTo);
//                status.setComplete();
//                return "redirect:meals";
//            } catch (DataIntegrityViolationException ex) {
//                result.rejectValue("email", "exception.duplicate_email");
//            }
//        }
//        return "profile";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register(ModelMap model) {
//        model.addAttribute("userTo", new UserTo());
//        model.addAttribute("register", true);
//        return "profile";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
//        if (!result.hasErrors()) {
//            try {
//                super.create(UserUtil.createNewFromTo(userTo));
//                status.setComplete();
//                return "redirect:login?message=app.registered";
//            } catch (DataIntegrityViolationException ex) {
//                result.rejectValue("email", "exception.duplicate_email");
//            }
//        }
//        model.addAttribute("register", true);
//        return "profile";
//    }

}
