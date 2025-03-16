package lk.ijse.cmjd109.LibMgmt109.service.impl.secure;

import lk.ijse.cmjd109.LibMgmt109.dao.secure.UserDao;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.SignIn;
import lk.ijse.cmjd109.LibMgmt109.dto.secure.UserDTO;
import lk.ijse.cmjd109.LibMgmt109.entities.UserEntity;
import lk.ijse.cmjd109.LibMgmt109.secureConfig.JWTUtils;
import lk.ijse.cmjd109.LibMgmt109.service.secure.AuthService;
import lk.ijse.cmjd109.LibMgmt109.util.EntityDTOConversion;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDao userDao;
    private final JWTUtils jwtUtils;
    private final EntityDTOConversion entityDTOConversion;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTResponse SignIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var signInUser = userDao.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtUtils.generateToken(signInUser.getEmail(), signInUser.getAuthorities());
        return JWTResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTResponse SignUp(UserDTO userDTO) {
       userDTO.setUserId(UtilityData.generateUserId());
       userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
       var savedUser =
               userDao.save(entityDTOConversion.toUserEntity(userDTO));
        var generatedToken = jwtUtils.generateToken(savedUser.getEmail(), savedUser.getAuthorities());
        return JWTResponse.builder().token(generatedToken).build();


    }
}
