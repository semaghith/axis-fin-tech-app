package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.response.BalanceResponse;
import assessment.fin_tech_app.mapper.TransactionMapper;
import assessment.fin_tech_app.payload.ApiResponse;
import assessment.fin_tech_app.service.UserService;
import assessment.fin_tech_app.utils.Constants;
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
    public ApiResponse<BalanceResponse> retrieveBalance(@PathVariable Long userId) throws Exception {

        BigDecimal balance = userService.retrieveBalance(userId);

        BalanceResponse response = new BalanceResponse(userId, balance);

        return ApiResponse.success(Constants.SuccessMessages.BALANCE_RETRIEVED_SUCCESSFULLY, 200, response);
    }
}
