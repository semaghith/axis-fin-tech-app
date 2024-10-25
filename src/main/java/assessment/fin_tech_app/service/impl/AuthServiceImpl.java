package assessment.fin_tech_app.service.impl;

import assessment.fin_tech_app.controller.dto.request.LoginRequest;
import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.mapper.AuthMapper;
import assessment.fin_tech_app.repository.UserRepository;
import assessment.fin_tech_app.service.AuthService;
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
    public Long login(LoginRequest request) {

        if (!userRepository.existsByUsernameAndDeletedFalse(request.username())) {
            return null;
        }
        
        return 0L;
    }

    @Override
    public Long register(RegisterRequest request) {

        if (userRepository.existsByUsernameAndDeletedFalse(request.username())) {
            return null;
        }

        User user = authMapper.toEntity(request);

//        TODO: hash password
        user.setPassword(request.password());

        userRepository.save(user);

        return user.getId();
    }
}
