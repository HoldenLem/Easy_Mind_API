package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void shouldConvertUserToUserDTO() {
        User user = User.builder()
                .id(1)
                .firstName("Volodymyr")
                .lastName("Ivanov")
                .password("secret123")
                .email("ivanov.volodymyr@gmail.com")
                .build();
        UserDTO actualUserDto = userMapper.userToUserDTO(user);
        UserDTO expectedUserDTO = UserDTO.builder()
                .id(1)
                .firstName("Volodymyr")
                .lastName("Ivanov")
                .password("secret123")
                .email("ivanov.volodymyr@gmail.com")
                .build();
        assertThat(actualUserDto).isEqualTo(expectedUserDTO);
    }
}
