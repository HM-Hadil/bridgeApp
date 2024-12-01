package ismg.bridgeapp.mappers;

import ismg.bridgeapp.Publications;
import ismg.bridgeapp.result.PubResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component

public class PubMapper {

    private final UserMapper userMapper;

    public PubResult entityToPub(Publications publications) {
        if (publications == null) {
            return null;
        }
        return PubResult.builder()
                .withId(publications.getId())
                .withUserpub(userMapper.entityToUser(publications.getUser()))
                .withContent(publications.getContent())
                .build();



    }
}