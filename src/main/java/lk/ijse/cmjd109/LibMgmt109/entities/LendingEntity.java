package lk.ijse.cmjd109.LibMgmt109.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LendingEntity {
    @Id
    private String lendingId;
    private String book;
    private String member;
    private LocalDate lendingDate;
    private LocalDate returnDate;
    private Boolean isActive;
    private Integer overDue;
    private Double fineAmount;
}
