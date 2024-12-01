package ismg.bridgeapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String language;
}
