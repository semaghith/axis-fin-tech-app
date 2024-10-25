package assessment.fin_tech_app.service;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;

public interface AuthService {

    Long login(LoginRequest request) throws Exception;

    Long register(RegisterRequest request) throws Exception;
}
