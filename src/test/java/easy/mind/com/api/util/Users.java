package easy.mind.com.api.util;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Users {
    private static final String DEFAULT_USERNAME = "Tony";
    private static final String DEFAULT_LASTNAME = "Soprano";
    private static final String DEFAULT_EMAIL = "user@gmail.com";

    public static UserDTO dto() {
        return UserDTO.builder()
                .firstName(DEFAULT_USERNAME)
                .lastName(DEFAULT_LASTNAME)
                .email(DEFAULT_EMAIL)
                .build();
    }

    public static User entity() {
        return User.builder()
                .firstName(DEFAULT_USERNAME)
                .lastName(DEFAULT_LASTNAME)
                .email(DEFAULT_EMAIL)
                .build();
    }
}
