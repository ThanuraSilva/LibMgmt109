package lk.ijse.cmjd109.LibMgmt109.dao;

import lk.ijse.cmjd109.LibMgmt109.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity,String> {
}
