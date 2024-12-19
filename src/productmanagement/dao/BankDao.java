package productmanagement.dao;

import java.util.List;

import productmanagement.model.dto.BankSearchDTO;
import productmanagement.model.entity.Bank;

public interface BankDao {
    boolean addBank(Bank Bank);

    boolean updateBank(Bank Bank);

    boolean deleteBank(int id);

    List<Bank> getAllBanks();

    List<Bank> searchBank(BankSearchDTO modelSearch);

    Bank searchBankById(int id);
}
