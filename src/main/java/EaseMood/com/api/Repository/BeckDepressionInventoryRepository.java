package EaseMood.com.api.Repository;

import EaseMood.com.api.Entity.BeckDepressionInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeckDepressionInventoryRepository extends JpaRepository<BeckDepressionInventory, Long> {

}
