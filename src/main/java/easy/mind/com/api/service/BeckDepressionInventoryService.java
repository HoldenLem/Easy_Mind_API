package easy.mind.com.api.service;

import easy.mind.com.api.entity.BeckDepressionInventory;
import easy.mind.com.api.entity.User;

public interface BeckDepressionInventoryService {

    int getResult(BeckDepressionInventory inventory, User user);
}
