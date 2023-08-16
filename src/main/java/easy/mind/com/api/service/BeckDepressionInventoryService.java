package easy.mind.com.api.service;

import easy.mind.com.api.DTO.BeckDepressionInventoryDTO;


import java.util.List;

public interface BeckDepressionInventoryService {

    BeckDepressionInventoryDTO create(BeckDepressionInventoryDTO inventoryDTO, int userId);

    List<BeckDepressionInventoryDTO> getByUserId(int userId);

}
