package lk.ijse.cmjd109.LibMgmt109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibStaffDTO implements Serializable {
    private String staffId;
    private String fName;
    private String lName;
    private String email;
    private String joinDate;
    private String lastUpdated;
    private Role role;
}
