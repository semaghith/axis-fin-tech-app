package assessment.fin_tech_app.service.impl;

import assessment.fin_tech_app.controller.dto.request.TransactionRequest;
import assessment.fin_tech_app.entity.Transaction;
import assessment.fin_tech_app.entity.User;
import assessment.fin_tech_app.entity.enums.TransactionType;
import assessment.fin_tech_app.exception.ApiException;
import assessment.fin_tech_app.repository.TransactionRepository;
import assessment.fin_tech_app.repository.UserRepository;
import assessment.fin_tech_app.service.TransactionService;
import assessment.fin_tech_app.utils.Constants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Transaction depositMoney(TransactionRequest request) {

        User user = userRepository.findByIdAndDeletedFalse(request.userId());

        if (user == null) {
            throw new ApiException(Constants.ErrorMessages.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        Transaction transaction = buildTransaction(request.amount(), TransactionType.DEPOSIT, user);

        BigDecimal newBalance = user.getBalance().add(request.amount());
        user.setBalance(newBalance);

        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public Transaction withdrawMoney(TransactionRequest request) {

        User user = userRepository.findByIdAndDeletedFalse(request.userId());

        if (user == null) {
            throw new ApiException(Constants.ErrorMessages.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        if (user.getBalance().compareTo(request.amount()) < 0) {
            throw new ApiException(Constants.ErrorMessages.LOW_BALANCE, HttpStatus.BAD_REQUEST);
        }

        Transaction transaction = buildTransaction(request.amount(), TransactionType.WITHDRAW, user);

        BigDecimal newBalance = user.getBalance().subtract(request.amount());
        user.setBalance(newBalance);

        return transactionRepository.save(transaction);
    }

    Transaction buildTransaction(BigDecimal amount, TransactionType type, User user) {

        return Transaction.builder()
                .amount(amount)
                .type(type)
                .user(user)
                .build();
    }
}
