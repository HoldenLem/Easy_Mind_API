package easy.mind.com.api.service;

import easy.mind.com.api.DTO.BeckDepressionInventoryDTO;
import easy.mind.com.api.DTO.conversion.BeckDepressionToDTO;
import easy.mind.com.api.DTO.conversion.UserDtoToUser;
import easy.mind.com.api.entity.BeckDepressionInventory;
import easy.mind.com.api.entity.User;
import easy.mind.com.api.repository.BeckDepressionInventoryRepository;
import easy.mind.com.api.service.Impl.BeckDepressionInventoryServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BeckDepressionInventoryTests {

    @Mock
    private BeckDepressionInventoryRepository repository;

    @Mock
    private UserService userService;
    @InjectMocks
    private BeckDepressionInventoryServiceImpl service;


    @Test
    public void createBeckDepressionInventory() {
        // given
        User user = createUserForTesting();

        BeckDepressionInventory expectedInventory = createBeckDepressionInventoryForTesting();
        BeckDepressionInventory expectedInventoryForReturn = createBeckDepressionInventoryForTesting();

        when(repository.save(expectedInventory)).thenReturn(expectedInventoryForReturn);
        when(userService.readById(user.getId())).thenReturn(UserDtoToUser.convert(user));
        //when
        BeckDepressionInventoryDTO actualInventory = service.create(BeckDepressionToDTO.convert(expectedInventory), 7);
        //then
        assertEquals(BeckDepressionToDTO.convert(expectedInventoryForReturn), actualInventory, "Inventory is not created");

        Mockito.verify(repository).save(expectedInventory);

    }

    @Test
    public void createBeckDepressionInventoryWithDefunctUserId() {
        // given
        BeckDepressionInventory expectedInventory = createBeckDepressionInventoryForTesting();
        when(userService.readById(3)).thenThrow(new EntityNotFoundException("User with id 3 not found"));
        // when
        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> service.create(BeckDepressionToDTO.convert(expectedInventory),3),
                "Expected readById() to throw, but it didn't"
        );
        // then
        assertTrue(thrown.getMessage().contains("User with id"));

        Mockito.verify(userService).readById(3L);
        Mockito.verify(repository, never()).save(any());

    }

    @Test
    public void getByUserId(){

        // given
        User user = createUserForTesting();

        BeckDepressionInventory expectedInventory = createBeckDepressionInventoryForTesting();
        List<BeckDepressionInventory> usersListWithInventories = new ArrayList<>();
        usersListWithInventories.add(expectedInventory);

        when(userService.readById(7)).thenReturn(UserDtoToUser.convert(user));
        when(repository.getByUserId(user.getId())).thenReturn(usersListWithInventories);
        //when
        List<BeckDepressionInventoryDTO> actualUsersListWithInventories = service.getByUserId(user.getId());
        //then
        assertEquals(actualUsersListWithInventories.stream() .map(BeckDepressionToDTO::convert)
                .toList(), usersListWithInventories,"There no such list");

        verify(repository).getByUserId(user.getId());
    }
    @Test
    public void getByDefunctUserId(){
        //when
        when(userService.readById(3)).thenThrow(new EntityNotFoundException("User with id 3 not found"));

        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> service.getByUserId(3),
                "Expected readById() to throw, but it didn't"
        );
        //then
        assertTrue(thrown.getMessage().contains("User with id"));

        Mockito.verify(userService).readById(3L);
        Mockito.verify(repository, never()).getByUserId(3);
    }

    private User createUserForTesting(){
        return User.builder()
                .id(7)
                .firstName("TestName")
                .lastName("TestLastName")
                .email("testEmail")
                .password("testPassword")
                .build();
    }
    private BeckDepressionInventory createBeckDepressionInventoryForTesting(){
        Instant instant = Instant.now();
        return BeckDepressionInventory.builder()
                .id(1)
                .createdAt(instant)
                .sadness(1)
                .concerns(1)
                .selfEsteem(1)
                .pleasure(1)
                .fault(1)
                .punishment(1)
                .selfLove(1)
                .selfCriticism(1)
                .suicide(1)
                .weep(1)
                .irritability(1)
                .interestInPeople(1)
                .determination(1)
                .appearance(1)
                .workAbility(1)
                .sleep(1)
                .fatigue(1)
                .appetite(1)
                .weight(1)
                .heals(1)
                .libido(1)
                .userId(7)
                .build();
    }


}
