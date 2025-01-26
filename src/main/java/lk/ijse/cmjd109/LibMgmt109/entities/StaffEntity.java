package lk.ijse.cmjd109.LibMgmt109.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.cmjd109.LibMgmt109.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    private String staffId;
    private String fName;
    private String lName;
    private String email;
    private LocalDate joinDate;
    private LocalDate lastUpdated;
    private Role role;
}
