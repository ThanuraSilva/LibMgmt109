package lk.ijse.cmjd109.LibMgmt109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO implements Serializable {
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
