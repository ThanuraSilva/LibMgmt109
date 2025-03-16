package lk.ijse.cmjd109.LibMgmt109.controller.secure;

import lk.ijse.cmjd109.LibMgmt109.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.SignIn;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.UserDTO;
import lk.ijse.cmjd109.LibMgmt109.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("signin")
    public ResponseEntity<JWTResponse> signIn(@RequestBody SignIn signIn) {
        return new ResponseEntity<>(authService.SignIn(signIn), HttpStatus.OK);
    }
    @PostMapping("signup")
    public ResponseEntity<JWTResponse> signUp(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(authService.SignUp(userDTO), HttpStatus.OK);
    }
}

