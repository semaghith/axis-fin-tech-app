package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.controller.dto.response.UserResponse;
import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.exception.ApiException;
import assessment.fin_tech_app.payload.ApiResponse;
import assessment.fin_tech_app.service.AuthService;
import assessment.fin_tech_app.utils.Constants;
import assessment.fin_tech_app.utils.Utils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ApiResponse<UserResponse> login(@RequestBody @Valid LoginRequest request) throws Exception {

        User user = authService.login(request);

        UserResponse response = new UserResponse(user.getId(), user.getUsername());

        return ApiResponse.success(200, response);
    }

    @PostMapping(path = "/register")
    public ApiResponse<UserResponse> register(@RequestBody @Valid RegisterRequest request) throws Exception {

        if (request.mobileNumber() != null && !Utils.isValidMobileNumber(request.mobileNumber())) {
            throw new ApiException(Constants.ErrorMessages.INVALID_MOBILE_NUMBER, HttpStatus.BAD_REQUEST);
        }

        if (!Utils.isValidPassword(request.password())) {
            throw new ApiException(Constants.ErrorMessages.INVALID_PASSWORD, HttpStatus.BAD_REQUEST);
        }

        User user = authService.register(request);

        UserResponse response = new UserResponse(user.getId(), user.getUsername());

        return ApiResponse.success(200, response);
    }
}
