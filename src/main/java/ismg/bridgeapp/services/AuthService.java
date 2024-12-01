package ismg.bridgeapp.services;

import ismg.bridgeapp.User;
import ismg.bridgeapp.exceptions.BadCredentialsException;
import ismg.bridgeapp.exceptions.UsernameNotFoundException;
import ismg.bridgeapp.repo.UserRepo;
import ismg.bridgeapp.request.UserLoginRequest;
import ismg.bridgeapp.request.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepository;

    public void register(UserRegisterRequest request) {
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .language(request.getLanguage())
                .build();

        userRepository.save(user);
    }

    public User login(UserLoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        if (!user.getPassword().equals(request.getPassword())) { // Compare plain-text passwords
            throw new BadCredentialsException("Invalid credentials!");
        }

        // Generate JWT token or manage authentication session as per your application logic
        return user;
    }



}
