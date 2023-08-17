package easy.mind.com.api.service.Impl;

import easy.mind.com.api.DTO.BeckDepressionInventoryDTO;
import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.DTO.conversion.BeckDepressionToDTO;
import easy.mind.com.api.entity.BeckDepressionInventory;
import easy.mind.com.api.repository.BeckDepressionInventoryRepository;
import easy.mind.com.api.service.BeckDepressionInventoryService;
import easy.mind.com.api.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeckDepressionInventoryServiceImpl implements BeckDepressionInventoryService {

    private final BeckDepressionInventoryRepository repository;

    private final UserService userService;

    @Override
    @Transactional
    public BeckDepressionInventoryDTO create(int userId, BeckDepressionInventoryDTO inventoryDTO) {

        BeckDepressionInventory inventory = BeckDepressionToDTO.convert(inventoryDTO);
        userService.throwIfNotExist(userId);
        UserDTO user = userService.readById(userId);
        inventory.setUserId(user.getId());
        BeckDepressionInventory newInventory = repository.save(inventory);
        return BeckDepressionToDTO.convert(newInventory);
    }

    @Override
    public List<BeckDepressionInventoryDTO> getByUserId(int userId) {
        userService.throwIfNotExist(userId);
        return repository.getByUserId(userId)
                .stream()
                .map(BeckDepressionToDTO::convert)
                .toList();
    }

}
