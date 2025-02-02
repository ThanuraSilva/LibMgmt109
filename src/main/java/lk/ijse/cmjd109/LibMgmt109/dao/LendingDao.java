package lk.ijse.cmjd109.LibMgmt109.dao;

import lk.ijse.cmjd109.LibMgmt109.entities.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingDao extends JpaRepository<LendingEntity,String> {
}
