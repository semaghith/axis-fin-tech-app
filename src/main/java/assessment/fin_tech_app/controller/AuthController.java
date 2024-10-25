package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.service.AuthService;
import assessment.fin_tech_app.utils.Constants;
import assessment.fin_tech_app.utils.Utils;
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
    public Long login(@RequestBody @Valid LoginRequest request) throws Exception {

        return authService.login(request);
    }

    @PostMapping(path = "/register")
    public Long register(@RequestBody @Valid RegisterRequest request) throws Exception {

        if (request.mobileNumber() != null && !Utils.isValidMobileNumber(request.mobileNumber())) {
            throw new Exception(Constants.ErrorMessages.INVALID_MOBILE_NUMBER);
        }

        if(!Utils.isValidPassword(request.password())){
            throw new Exception(Constants.ErrorMessages.INVALID_PASSWORD);
        }

        return authService.register(request);
    }
}
