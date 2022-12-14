package no.hvl.dat250.jpa.assignment.web.controller.poll;

import no.hvl.dat250.jpa.assignment.authenticationfacade.AuthenticationFacade;
import no.hvl.dat250.jpa.assignment.models.poll.Poll;
import no.hvl.dat250.jpa.assignment.models.user.User;
import no.hvl.dat250.jpa.assignment.service.poll.PollService;
import no.hvl.dat250.jpa.assignment.service.user.UserService;
import no.hvl.dat250.jpa.assignment.web.formobject.PollCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class PollCreateController {
    private final PollService pollService;
    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public PollCreateController(PollService pollService, UserService userService, AuthenticationFacade authenticationFacade) {
        this.pollService = pollService;
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping(value = "/poll/create")
    public String showForm(Model model) {
        model.addAttribute("pollCreateForm", new PollCreateForm());

        return "poll/pollcreation";
    }

    @PostMapping(value = "/poll/create")
    public String validateInput(@Valid PollCreateForm pollCreateForm, BindingResult bindResult) {
        Authentication authentication = authenticationFacade.getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }

        if (bindResult.hasErrors()) {
            bindResult.getAllErrors().forEach(e -> System.out.println(e.toString()));
            return "redirect:/poll/pollcreation";
        }

        User u;

        try {
            u = userService.getUserByUsername(authentication.getName());
        } catch (NoSuchElementException e) {
            return "redirect:/login";
        }

        Poll poll = new Poll(pollCreateForm.getQuestion().replaceAll("\\s+", " ").trim(), pollCreateForm.getTheme().replaceAll("\\s+", " ").trim(), pollCreateForm.getIsPrivate(), u);

        pollService.createPoll(poll);

        return "redirect:/poll/" + poll.getId();
    }
}
