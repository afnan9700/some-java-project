package com.somedomain.collab_editor_proto.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // constructor injection
    public AuthController(AuthService service) {
        this.authService = service;
    }

    // request DTOs
    record SignupRequest(String username, String password) {}
    record LoginRequest(String username, String password) {}

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest req) {
        authService.signup(req.username(), req.password());
        return "Signup successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        authService.login(req.username(), req.password());
        return "Login successful (JWT coming soon)";
    }
}
