package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.response.BalanceResponse;
import assessment.fin_tech_app.payload.ApiPayload;
import assessment.fin_tech_app.service.UserService;
import assessment.fin_tech_app.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Retrieve user balance", description = "Get the balance of a user by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of balance"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping(path = "/{userId}/balance")
    public ApiPayload<BalanceResponse> retrieveBalance(@PathVariable Long userId) {

        BigDecimal balance = userService.retrieveBalance(userId);

        BalanceResponse response = new BalanceResponse(userId, balance);

        return ApiPayload.success(Constants.SuccessMessages.BALANCE_RETRIEVED_SUCCESSFULLY, 200, response);
    }
}
