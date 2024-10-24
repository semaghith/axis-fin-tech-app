package assessment.fin_tech_app.repository;

import assessment.fin_tech_app.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends
        JpaRepository<Long, Transaction> {

}