package assessment.fin_tech_app.service;

import java.math.BigDecimal;

public interface UserService {

    BigDecimal retrieveBalance(Long userId);
}
