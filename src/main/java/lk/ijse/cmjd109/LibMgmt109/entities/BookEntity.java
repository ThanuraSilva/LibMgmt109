package lk.ijse.cmjd109.LibMgmt109.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookEntity {
    @Id
    private String bookId;
    private String title;
    private String publisher;
    private String isbn;
    private String author;
    private String edition;
    private Double price;
    private Integer totalQty;
    private Integer avilableQty;
    private LocalDate lastUpdatedDate;
    private Time lastUpdatedTime;
}
