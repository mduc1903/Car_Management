package productmanagement.services;

import java.util.List;

import productmanagement.model.dto.BankSearchDTO;
import productmanagement.model.entity.Bank;

public interface BankService {
	public boolean addBank(Bank b);

	public boolean editBank(Bank b);

	public boolean delBank(int id);

	public List<Bank> searchBank(BankSearchDTO modelSearch);

	public List<Bank> sortedBank();

	public List<Bank> sortedBankByFee();

	List<Bank> getAllBanks();

	Bank searchBankById(int id);
}
