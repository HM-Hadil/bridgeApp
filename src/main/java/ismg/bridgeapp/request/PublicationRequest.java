package ismg.bridgeapp.request;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
@SuperBuilder
@Data

@Validated
@ToString
@Jacksonized
public class PublicationRequest {
    private Long id;
    private Long userId;
    private String content;
    private Date cretedOn;
}