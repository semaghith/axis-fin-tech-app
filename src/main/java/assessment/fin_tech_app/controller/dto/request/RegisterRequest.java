package assessment.fin_tech_app.controller.dto.request;

public record RegisterRequest(

        String username,
        String password,
        String mobileNumber
) {
}
