package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{userId}/balance")
    public BigDecimal retrieveBalance(@PathVariable Long userId) throws Exception {

        return userService.retrieveBalance(userId);
    }
}
