package easy.mind.com.api.DTO.conversion;

import easy.mind.com.api.DTO.BeckDepressionInventoryDTO;
import easy.mind.com.api.entity.BeckDepressionInventory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BeckDepressionToDTO {

    public static BeckDepressionInventory convert(BeckDepressionInventoryDTO dto){

        return BeckDepressionInventory.builder()
                .id(dto.getId())
                .createdAt(dto.getCreatedAt())
                .sadness(dto.getSadness())
                .concerns(dto.getConcerns())
                .selfEsteem(dto.getSelfEsteem())
                .pleasure(dto.getPleasure())
                .fault(dto.getFault())
                .punishment(dto.getPunishment())
                .selfLove(dto.getSelfLove())
                .selfCriticism(dto.getSelfCriticism())
                .suicide(dto.getSuicide())
                .weep(dto.getWeep())
                .irritability(dto.getIrritability())
                .interestInPeople(dto.getInterestInPeople())
                .determination(dto.getDetermination())
                .appearance(dto.getAppearance())
                .workAbility(dto.getWorkAbility())
                .sleep(dto.getSleep())
                .fatigue(dto.getFatigue())
                .appetite(dto.getAppetite())
                .weight(dto.getWeight())
                .heals(dto.getHeals())
                .libido(dto.getLibido())
                .userId(dto.getUserId())
                .build();
    }

    public static BeckDepressionInventoryDTO convert(BeckDepressionInventory entity){
        return BeckDepressionInventoryDTO.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .sadness(entity.getSadness())
                .concerns(entity.getConcerns())
                .selfEsteem(entity.getSelfEsteem())
                .pleasure(entity.getPleasure())
                .fault(entity.getFault())
                .punishment(entity.getPunishment())
                .selfLove(entity.getSelfLove())
                .selfCriticism(entity.getSelfCriticism())
                .suicide(entity.getSuicide())
                .weep(entity.getWeep())
                .irritability(entity.getIrritability())
                .interestInPeople(entity.getInterestInPeople())
                .determination(entity.getDetermination())
                .appearance(entity.getAppearance())
                .workAbility(entity.getWorkAbility())
                .sleep(entity.getSleep())
                .fatigue(entity.getFatigue())
                .appetite(entity.getAppetite())
                .weight(entity.getWeight())
                .heals(entity.getHeals())
                .libido(entity.getLibido())
                .userId(entity.getUserId())
                .build();
    }
}
