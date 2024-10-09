package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserMapperTests {
    @Autowired
    UserMapper mapper;

    @Test
    void entityDto() {
        User user = User.builder()
                .id(1)
                .firstName("Volodymyr")
                .lastName("Ivanov")
                .password("secret123")
                .email("ivanov.volodymyr@gmail.com")
                .build();
        UserDTO actualUserDto = mapper.of(user);
        UserDTO expectedUserDTO = UserDTO.builder()
                .id(1)
                .firstName("Volodymyr")
                .lastName("Ivanov")
                .password("secret123")
                .email("ivanov.volodymyr@gmail.com")
                .build();
        assertThat(actualUserDto).isEqualTo(expectedUserDTO);
    }

    @Test
    void dtoToEntity() {
        UserDTO userDTO= UserDTO.builder()
                .id(0)
                .firstName("Natalia")
                .lastName("Jonson")
                .password("12345678")
                .email("jonson.natalia@gmail.edu")
                .build();
        User actualUser = mapper.of(userDTO);
        User expectedUser = User.builder()
                .id(0)
                .firstName("Natalia")
                .lastName("Jonson")
                .password("12345678")
                .email("jonson.natalia@gmail.edu")
                .build();
        assertThat(actualUser).isEqualTo(expectedUser);
    }
}
