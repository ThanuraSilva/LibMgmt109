package lk.ijse.cmjd109.LibMgmt109.dao.secure;

import lk.ijse.cmjd109.LibMgmt109.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDao extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
