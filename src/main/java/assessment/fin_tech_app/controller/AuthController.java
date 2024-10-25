package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/login")
    public Long login(@RequestBody @Valid LoginRequest request) {

        return authService.login(request);
    }

    @PostMapping(path = "/register")
    public Long register(@RequestBody @Valid RegisterRequest request) {

        return authService.register(request);
    }
}
