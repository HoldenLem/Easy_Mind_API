package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import easy.mind.com.api.util.Users;
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
        User user = Users.entity();
        UserDTO expectedUserDTO = Users.dto();

        UserDTO actualUserDto = mapper.of(user);

        assertThat(actualUserDto).isEqualTo(expectedUserDTO);
        assertThat(actualUserDto.getFirstName()).isEqualTo(expectedUserDTO.getFirstName());
        assertThat(actualUserDto.getLastName()).isEqualTo(expectedUserDTO.getLastName());

    }

    @Test
    void dtoToEntity() {
        UserDTO userDTO= Users.dto();
        User expectedUser = Users.entity();

        User actualUser = mapper.of(userDTO);

        assertThat(actualUser).isEqualTo(expectedUser);
        assertThat(actualUser.getFirstName()).isEqualTo(expectedUser.getFirstName());
        assertThat(actualUser.getLastName()).isEqualTo(expectedUser.getLastName());

    }
}
