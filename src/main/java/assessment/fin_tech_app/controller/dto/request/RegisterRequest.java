package assessment.fin_tech_app.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(

        @NotBlank(message = "Username is mandatory field")
        String username,

        @NotBlank(message = "Password is mandatory field")
        String password,

        String mobileNumber
) {
}
