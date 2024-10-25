package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.controller.dto.response.UserResponse;
import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.exception.ApiException;
import assessment.fin_tech_app.payload.ApiPayload;
import assessment.fin_tech_app.service.AuthService;
import assessment.fin_tech_app.utils.Constants;
import assessment.fin_tech_app.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "User Login", description = "Authenticates a user based on username and password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class))),
            @ApiResponse(responseCode = "400", description = "User not found or invalid credentials",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class)))
    })
    @PostMapping(path = "/login")
    public ApiPayload<UserResponse> login(@RequestBody @Valid LoginRequest request) throws Exception {

        User user = authService.login(request);

        UserResponse response = new UserResponse(user.getId(), user.getUsername());

        return ApiPayload.success(200, response);
    }

    @Operation(summary = "User Registration", description = "Registers a new user with username, password, and optional mobile number.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registration successful",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class))),
            @ApiResponse(responseCode = "400", description = "Invalid mobile number, password, or username already exists",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class)))
    })
    @PostMapping(path = "/register")
    public ApiPayload<UserResponse> register(@RequestBody @Valid RegisterRequest request) throws Exception {

        if (request.mobileNumber() != null && !Utils.isValidMobileNumber(request.mobileNumber())) {
            throw new ApiException(Constants.ErrorMessages.INVALID_MOBILE_NUMBER, HttpStatus.BAD_REQUEST);
        }

        if (!Utils.isValidPassword(request.password())) {
            throw new ApiException(Constants.ErrorMessages.INVALID_PASSWORD, HttpStatus.BAD_REQUEST);
        }

        User user = authService.register(request);

        UserResponse response = new UserResponse(user.getId(), user.getUsername());

        return ApiPayload.success(200, response);
    }
}
