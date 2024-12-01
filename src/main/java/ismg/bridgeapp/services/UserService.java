package ismg.bridgeapp.services;

import ismg.bridgeapp.User;
import ismg.bridgeapp.mappers.UserMapper;
import ismg.bridgeapp.repo.UserRepo;
import ismg.bridgeapp.result.UserResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;


    //get user by id
    public UserResult findUserById(Long id) {
        return userMapper.entityToUser(userRepo.findById(id).orElse(null));
    }
    public Optional<User>  findUserByemail(String email){
        return this.userRepo.findByEmail(email);
    }


}