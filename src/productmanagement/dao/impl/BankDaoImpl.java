package productmanagement.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import productmanagement.dao.BankDao;
import productmanagement.model.dto.BankSearchDTO;
import productmanagement.model.entity.Bank;
import productmanagement.utils.StringUtils;

public class BankDaoImpl implements BankDao{
	private List<Bank> bankList;
	private static final String FILE_NAME = "Bank.bin";
	private static int currentId;
	
	public BankDaoImpl() {
		bankList = loadBankList();
		if (!bankList.isEmpty()) {
			currentId = bankList.get(bankList.size() - 1).getId();
		} else {
			currentId = 0;
		}
	}

	@Override
	public boolean addBank(Bank Bank) {
		Bank.setId(generateId());
		if (bankList.add(Bank)) {
			saveBankList();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBank(Bank bank) {
		for (int i = 0; i < bankList.size(); i++) {
			if (bankList.get(i).getId() == bank.getId()) {
				bankList.set(i, bank);
				saveBankList();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteBank(int id) {
		if (bankList.removeIf(bank -> bank.getId() == id)) {
			saveBankList();
			return true;
		}
		return false;
	}

	@Override
	public List<Bank> getAllBanks() {
		List<Bank> result = loadBankList();
		return result;
	}

	@Override
	public List<Bank> searchBank(BankSearchDTO modelSearch) {
		List<Bank> result = new ArrayList<>();
		System.out.println(modelSearch.toString());
		bankList.forEach(item -> {
			boolean flag = true;
			if (StringUtils.checkString(modelSearch.getName())) {
				if (!item.getName().equalsIgnoreCase(modelSearch.getName())) {
					flag = false;
				}
			}
			if (modelSearch.getMinFee() != -1.0) {
				if (item.getFee() < modelSearch.getMinFee()) {
					flag = false;
				}
			}
			if (modelSearch.getMaxFee() != -1.0) {
				if (item.getFee() > modelSearch.getMaxFee()) {
					flag = false;
				}
			}
			if (flag) {
				result.add(item);
			}
		});
		return result;
	}

	@Override
	public Bank searchBankById(int id) {
		Bank c = new Bank();
		for (Bank element : bankList) {
			if (element.getId() == id) {
				c = element;
			}
		}
		return c;
	}
	
	private void saveBankList() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (Bank bank : bankList) {
				writer.write(bank.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Bank> loadBankList() {
		List<Bank> BankList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String data;
			while ((data = reader.readLine()) != null) {
				Bank bank = Bank.fromStringToBank(data);
				BankList.add(bank);
			}
		} catch (IOException e) {
			BankList = new ArrayList<>();
		}
		return BankList;
	}

	private int generateId() {
		return ++currentId;
	}

}
