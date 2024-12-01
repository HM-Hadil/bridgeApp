package ismg.bridgeapp.services;
import ismg.bridgeapp.Publications;
import ismg.bridgeapp.User;
import ismg.bridgeapp.exceptions.UserNotFoundException;
import ismg.bridgeapp.exceptions.UsernameNotFoundException;
import ismg.bridgeapp.mappers.PubMapper;
import ismg.bridgeapp.repo.PublicationRepo;
import ismg.bridgeapp.repo.UserRepo;
import ismg.bridgeapp.request.PublicationRequest;
import ismg.bridgeapp.result.PubResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationService {
    private final UserRepo userRepository;
    private final PubMapper pubMapper;
    private final PublicationRepo publicationRepo;

    public PubResult createPublication(PublicationRequest req) {
        // Find the user by userId
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new UserNotFoundException(req.getUserId() ));

        var pub = Publications.builder()
                .id(req.getId())
                .content(req.getContent())
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();


        // Save the puserublication
        return pubMapper.entityToPub(publicationRepo.save(pub));
    }

    public List<Publications> getAllPublicationsByUserId(Long userId) {
        // Find publications by user id
        return publicationRepo.findPublicationsByUserId(userId);
    }
}