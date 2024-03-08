package kr.hs.gbsw.tree.user.service;

import kr.hs.gbsw.tree.user.dto.CreateUserDto;
import kr.hs.gbsw.tree.user.model.User;
import kr.hs.gbsw.tree.user.repository.UserRepository;
import kr.hs.gbsw.tree.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private JwtUtil jwtUtil;
    private PasswordEncoder passwordEncoder;



    public User createUser(CreateUserDto dto) {
        LocalDateTime now = LocalDateTime.now();

        User user = new User(
                dto.getId(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getName(),
                dto.getEmail(),
                now,
                now
        );
        return userRepository.save(user);
    }
        public User getMyProfileByToken(String token){
            String userId = jwtUtil.getSubject(token);
            if (!userRepository.existsById(userId)){
                throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
            }

            return userRepository.findById(userId).get();
        }



}
