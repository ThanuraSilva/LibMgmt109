package lk.ijse.cmjd109.LibMgmt109.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JWTResponse implements Serializable {
    private String token;
}
