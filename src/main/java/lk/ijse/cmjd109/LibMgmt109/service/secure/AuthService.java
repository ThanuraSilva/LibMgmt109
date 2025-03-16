package lk.ijse.cmjd109.LibMgmt109.service.secure;

import lk.ijse.cmjd109.LibMgmt109.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.SignIn;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.UserDTO;

public interface AuthService {
    JWTResponse SignIn(SignIn signIn);
    JWTResponse SignUp(UserDTO userDTO);
}
