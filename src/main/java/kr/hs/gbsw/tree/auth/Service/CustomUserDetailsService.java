package kr.hs.gbsw.tree.auth.Service;

import kr.hs.gbsw.tree.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!userRepository.existsById(username)){
            throw new UsernameNotFoundException(username + "에 해당하는 사용자가 존재하지 않습니다.");
        }
        return userRepository.findById(username).get();
    }
}
