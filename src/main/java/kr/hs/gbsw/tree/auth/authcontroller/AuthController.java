package kr.hs.gbsw.tree.auth.authcontroller;

import kr.hs.gbsw.tree.auth.authservice.AuthService;
import kr.hs.gbsw.tree.auth.dto.LoginDto;
import kr.hs.gbsw.tree.auth.dto.LoginResultDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResultDto login(
            @RequestBody LoginDto dto
    ){
        return authService.loginWithAuthenticationManager(dto);
    }
}
