package assessment.fin_tech_app.service.impl;

import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.repository.UserRepository;
import assessment.fin_tech_app.service.UserService;
import assessment.fin_tech_app.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public BigDecimal retrieveBalance(Long userId) throws Exception {

        User user = userRepository.findByIdAndDeletedFalse(userId);

        if (user == null) {
            throw new Exception(Constants.ErrorMessages.USER_NOT_FOUND);
        }

        return user.getBalance();
    }
}
