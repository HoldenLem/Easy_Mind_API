package easy.mind.com.api.facade;


import easy.mind.com.api.entity.BeckDepressionInventory;
import easy.mind.com.api.repository.BeckDepressionInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;



@Component
@RequiredArgsConstructor
public class TestsFacade {

   private final BeckDepressionInventoryRepository repository;


    public  boolean hasExceededRateLimit(int userId){
        return repository.findTopByUserIdOrderByCreatedAtDesc(userId)
                .map(BeckDepressionInventory::getCreatedAt)
                .map(x -> x.isAfter(Instant.now().minus(24, ChronoUnit.HOURS)))
                .orElse(false);
    }
}
