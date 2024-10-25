package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.service.AuthService;
import assessment.fin_tech_app.utils.Constants;
import assessment.fin_tech_app.utils.InputValidators;
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
    public Long register(@RequestBody @Valid RegisterRequest request) throws Exception {

        if(!InputValidators.isValidMobileNumber(request.mobileNumber())){
            throw new Exception(Constants.ErrorMessages.INVALID_MOBILE_NUMBER);
        }

        return authService.register(request);
    }
}
