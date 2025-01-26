package lk.ijse.cmjd109.LibMgmt109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO implements Serializable {
    private String memberId;
    private String name;
    private String email;
    private LocalDate memberShipDate;
}

