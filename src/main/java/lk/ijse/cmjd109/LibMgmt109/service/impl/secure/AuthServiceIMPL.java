package lk.ijse.cmjd109.LibMgmt109.service.impl.secure;

import lk.ijse.cmjd109.LibMgmt109.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.SignIn;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.UserDTO;
import lk.ijse.cmjd109.LibMgmt109.service.secure.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceIMPL implements AuthService {
    @Override
    public JWTResponse SignIn(SignIn signIn) {
        return null;
    }

    @Override
    public JWTResponse SignUp(UserDTO userDTO) {
        return null;
    }
}
