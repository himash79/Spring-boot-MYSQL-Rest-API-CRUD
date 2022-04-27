package lk.himash.employeeservice.controller;

import lk.himash.employeeservice.dto.AuthRequest;
import lk.himash.employeeservice.dto.AuthResponse;
import lk.himash.employeeservice.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
            validateAuthentication(authRequest.getUserName(), authRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
            String token = jwtUtil.generateToken(authRequest.getUserName());
        return ResponseEntity.ok(new AuthResponse(authRequest.getUserName(),token));
    }

    private void validateAuthentication(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        }catch(BadCredentialsException ex) {
            throw new Exception("Check Username / password again ! ", ex);
        }
    }

}
