package assessment.fin_tech_app.service.impl;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.exception.ApiException;
import assessment.fin_tech_app.mapper.AuthMapper;
import assessment.fin_tech_app.repository.UserRepository;
import assessment.fin_tech_app.service.AuthService;
import assessment.fin_tech_app.utils.Constants;
import assessment.fin_tech_app.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthMapper authMapper;

    @Override
    public User login(LoginRequest request) throws Exception {

        User user = userRepository.findByUsernameAndDeletedFalse(request.username());

        if (user == null) {
            throw new ApiException(Constants.ErrorMessages.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        if (!Utils.checkPassword(request.password(), user.getPassword())) {
            throw new ApiException(Constants.ErrorMessages.WRONG_USERNAME_OR_PASSWORD, HttpStatus.BAD_REQUEST);
        }

        return user;
    }

    @Override
    public User register(RegisterRequest request) throws Exception {

        if (userRepository.existsByUsernameAndDeletedFalse(request.username())) {
            throw new ApiException(Constants.ErrorMessages.USERNAME_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
        }

        User user = authMapper.toEntity(request);

        user.setPassword(Utils.hashPassword(request.password()));

        return userRepository.save(user);
    }
}
