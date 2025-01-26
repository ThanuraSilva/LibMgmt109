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
public class MemberEntity {
    @Id
    private String memberId;
    private String fName;
    private String lName;
    private String email;
    private LocalDate memberShipDate;
}
