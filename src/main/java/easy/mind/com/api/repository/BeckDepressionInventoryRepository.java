package easy.mind.com.api.repository;

import easy.mind.com.api.DTO.BeckDepressionInventoryDTO;
import easy.mind.com.api.entity.BeckDepressionInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeckDepressionInventoryRepository extends JpaRepository<BeckDepressionInventory, Long> {

   List<BeckDepressionInventory> getByUserId(int userId);
   Optional<BeckDepressionInventory> findTopByUserIdOrderByCreatedAtDesc(int userId);

}
