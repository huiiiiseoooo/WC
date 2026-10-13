package com.shinsw.working_record_backend.auth.jwt;

import com.shinsw.working_record_backend.user.Role;
import com.shinsw.working_record_backend.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JwtServiceTest {


    @Test
    public void testExample(){
        String key ="+WGes2HkoZz7bv4pgBGjl/xCqHYhB1DOQpDVOLu3DMU=";
        JwtService jwtService = new JwtService(key);
        User user = new User();
        user.setId("test12");
        user.setUsername("test");
        user.setPassword("testpw");
        user.setRole(Role.EMPLOYEE);
        String token = jwtService.provideJwt(user);

        String[] tokens = token.split("\\.");
        tokens[2]= "qwfidnnef";
        String testToken = tokens[0] + "." + tokens[1]+"."+tokens[2];

        assertThrows(SignatureException.class, () -> jwtService.verifyJwt(testToken));
    }
}
