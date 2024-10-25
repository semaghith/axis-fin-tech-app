package assessment.fin_tech_app.service.impl;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.mapper.AuthMapper;
import assessment.fin_tech_app.repository.UserRepository;
import assessment.fin_tech_app.service.AuthService;
import assessment.fin_tech_app.utils.Constants;
import assessment.fin_tech_app.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthMapper authMapper;

    @Override
    public Long login(LoginRequest request) throws Exception {

        User user = userRepository.findByUsernameAndDeletedFalse(request.username());

        if (user == null) {
            throw new Exception(Constants.ErrorMessages.USER_NOT_FOUND);
        }

        if (!Utils.checkPassword(request.password(), user.getPassword())) {
            throw new Exception(Constants.ErrorMessages.WRONG_USERNAME_OR_PASSWORD);
        }

        return user.getId();
    }

    @Override
    public Long register(RegisterRequest request) throws Exception {

        if (userRepository.existsByUsernameAndDeletedFalse(request.username())) {
            throw new Exception(Constants.ErrorMessages.USERNAME_ALREADY_EXISTS);
        }

        User user = authMapper.toEntity(request);

        user.setPassword(Utils.hashPassword(request.password()));

        userRepository.save(user);

        return user.getId();
    }
}
