package easy.mind.com.api.сontroller;

import easy.mind.com.api.DTO.BeckDepressionInventoryDTO;
import easy.mind.com.api.service.Impl.BeckDepressionInventoryServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/tests")
@RequiredArgsConstructor
public class TestsController {

    private final BeckDepressionInventoryServiceImpl beckDepressionService;

    @PostMapping("/depressions")
    public ResponseEntity<BeckDepressionInventoryDTO> create(
            @Valid @RequestBody BeckDepressionInventoryDTO beckDepression,
            @PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(beckDepressionService.create(beckDepression, userId));
    }

    @GetMapping("/depressions")
    public ResponseEntity<List<BeckDepressionInventoryDTO>> readByUserId(@PathVariable int userId){
        return ResponseEntity.ok().body(beckDepressionService.getByUserId(userId));
    }

}
