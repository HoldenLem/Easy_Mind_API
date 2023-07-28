package EaseMood.com.api.Srvice;

import EaseMood.com.api.Entity.BeckDepressionInventory;
import EaseMood.com.api.Entity.User;
import EaseMood.com.api.Repository.UserRepository;

public interface BeckDepressionInventoryService {

    int getResult(BeckDepressionInventory inventory, User user);
}
