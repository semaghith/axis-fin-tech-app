package assessment.fin_tech_app.service.impl;

import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.exception.ApiException;
import assessment.fin_tech_app.repository.UserRepository;
import assessment.fin_tech_app.service.UserService;
import assessment.fin_tech_app.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
            throw new ApiException(Constants.ErrorMessages.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        return user.getBalance();
    }
}
