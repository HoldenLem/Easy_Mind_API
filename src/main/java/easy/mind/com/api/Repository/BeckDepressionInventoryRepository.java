package easy.mind.com.api.Repository;

import easy.mind.com.api.Entity.BeckDepressionInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeckDepressionInventoryRepository extends JpaRepository<BeckDepressionInventory, Long> {

}
