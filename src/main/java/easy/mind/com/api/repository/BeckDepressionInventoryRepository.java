package easy.mind.com.api.repository;

import easy.mind.com.api.entity.BeckDepressionInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeckDepressionInventoryRepository extends JpaRepository<BeckDepressionInventory, Long> {

}
