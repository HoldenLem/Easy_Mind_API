package EaseMood.com.api.Srvice.Impl;

import EaseMood.com.api.Entity.BeckDepressionInventory;
import EaseMood.com.api.Entity.User;
import EaseMood.com.api.Repository.BeckDepressionInventoryRepository;
import EaseMood.com.api.Srvice.BeckDepressionInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeckDepressionInventoryServiceImpl implements BeckDepressionInventoryService {

    private BeckDepressionInventoryRepository repository;

    @Autowired
    public BeckDepressionInventoryServiceImpl(BeckDepressionInventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public int getResult(BeckDepressionInventory inventory, User user) {

        inventory.setUserId(user.getId());

        BeckDepressionInventory newInventory = repository.save(inventory);

        int sum = newInventory.getQuestionOne() + newInventory.getQuestionTwo() + newInventory.getQuestionThree() +
                newInventory.getQuestionFour() + newInventory.getQuestionFive() + newInventory.getQuestionSix() +
                newInventory.getQuestionSeven() + newInventory.getQuestionEight() + newInventory.getQuestionNine() +
                newInventory.getQuestionTen() + newInventory.getQuestionEleven() + newInventory.getQuestionTwelve() +
                newInventory.getQuestionThirteen() + newInventory.getQuestionFourteen() + newInventory.getQuestionFifteen() +
                newInventory.getQuestionSixteen() + newInventory.getQuestionSeventeen() + newInventory.getQuestionEighteen() +
                newInventory.getQuestionNineteen() + newInventory.getQuestionTwenty() + newInventory.getQuestionTwentyOne();
        return sum;
    }
}
