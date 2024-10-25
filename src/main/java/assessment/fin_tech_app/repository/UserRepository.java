package assessment.fin_tech_app.repository;

import assessment.fin_tech_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {


    @Query("SELECT COUNT(u) > 0 " +
            "FROM User u " +
            "WHERE u.username = :username " +
            "AND u.deleted = false ")
    boolean existsByUsernameAndDeletedFalse(String username);

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.username = :username " +
            "AND u.deleted = false ")
    User findByUsernameAndDeletedFalse(String username);

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.id = :id " +
            "AND u.deleted = false ")
    User findByIdAndDeletedFalse(Long id);
}
