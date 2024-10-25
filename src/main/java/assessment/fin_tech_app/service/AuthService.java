package assessment.fin_tech_app.service;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.entity.User;

public interface AuthService {

    User login(LoginRequest request) throws Exception;

    User register(RegisterRequest request) throws Exception;
}
