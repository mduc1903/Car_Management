package productmanagement.services.impl;

import java.util.List;

import productmanagement.model.dto.BankSearchDTO;
import productmanagement.model.entity.Bank;
import productmanagement.dao.BankDao;
import productmanagement.dao.impl.BankDaoImpl;
import productmanagement.services.BankService;

public class BankServiceImpl implements BankService{
	private BankDao BankDao = new BankDaoImpl();
	
	@Override
	public boolean addBank(Bank b) {
		return BankDao.addBank(b);
	}

	@Override
	public boolean editBank(Bank b) {
		return BankDao.updateBank(b);
	}

	@Override
	public boolean delBank(int id) {
		return BankDao.deleteBank(id);
	}

	@Override
	public List<Bank> searchBank(BankSearchDTO modelSearch) {
		List<Bank> result = BankDao.searchBank(modelSearch);
		return result;
	}

	@Override
	public List<Bank> sortedBank() {
		List<Bank> BankList = BankDao.getAllBanks();
		BankList.sort((c1, c2) -> Double.compare(c2.getId(), c1.getId()));
		return BankList;
	}

	@Override
	public List<Bank> sortedBankByFee() {
		List<Bank> BankList = BankDao.getAllBanks();
		BankList.sort((c1, c2) -> Double.compare(c1.getFee(), c2.getFee()));
		return BankList;
	}

	@Override
	public List<Bank> getAllBanks() {
		return BankDao.getAllBanks();
	}

	@Override
	public Bank searchBankById(int id) {
		return BankDao.searchBankById(id);
	}

}
