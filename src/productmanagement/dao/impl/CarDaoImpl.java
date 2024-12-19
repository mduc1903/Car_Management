package productmanagement.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import productmanagement.dao.CarDao;
import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;
import productmanagement.utils.StringUtils;

public class CarDaoImpl implements CarDao {
	private List<Car> carList;
	private static final String FILE_NAME = "Car.bin";
	private static int currentId;

	public CarDaoImpl() {
		carList = loadCarList();
		if (!carList.isEmpty()) {
			currentId = carList.get(carList.size() - 1).getId();
		} else {
			currentId = 0;
		}
	}

	@Override
	public boolean addCar(Car car) {
		car.setId(generateId());
		if (carList.add(car)) {
			saveCarList();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCar(Car car) {
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getId() == car.getId()) {
				carList.set(i, car);
				saveCarList();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCar(int id) {
		if (carList.removeIf(car -> car.getId() == id)) {
			saveCarList();
			return true;
		}
		return false;
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> result = loadCarList();
		return result;
	}

	@Override
	public List<Car> searchCar(CarSearchDTO modelSearch) {
		List<Car> result = new ArrayList<>();
		System.out.println(modelSearch.toString());
		carList.forEach(item -> {
			boolean flag = true;
			if (StringUtils.checkString(modelSearch.getName())) {
				if (!item.getName().equalsIgnoreCase(modelSearch.getName())) {
					flag = false;
				}
			}
			if (modelSearch.getMinPrice() != -1.0) {
				if (item.getPrice() < modelSearch.getMinPrice()) {
					flag = false;
				}
			}
			if (modelSearch.getMaxPrice() != -1.0) {
				if (item.getPrice() > modelSearch.getMaxPrice()) {
					flag = false;
				}
			}
			if (modelSearch.getMinSeats() != -1) {
				if (item.getNumberOfSeats() < modelSearch.getMinSeats()) {
					flag = false;
				}
			}
			if (modelSearch.getMaxSeats() != -1) {
				if (item.getNumberOfSeats() > modelSearch.getMaxSeats()) {
					flag = false;
				}
			}
			if (StringUtils.checkString(modelSearch.getTypeCar())) {
				if (!item.getTypeCar().equalsIgnoreCase(modelSearch.getTypeCar())) {
					flag = false;
				}
			}
			if (StringUtils.checkString(modelSearch.getColor())) {
				if (!item.getColor().equalsIgnoreCase(modelSearch.getColor())) {
					flag = false;
				}
			}
			if (flag) {
				result.add(item);
			}
		});
		return result;
	}

//    private void saveCarList() {
//        try (OutputStream os = new FileOutputStream(FILE_NAME);
//             ObjectOutputStream oos = new ObjectOutputStream(os)) {
//            oos.writeObject(carList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

	private void saveCarList() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (Car car : carList) {
				writer.write(car.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Car> loadCarList() {
		List<Car> carList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String data;
			while ((data = reader.readLine()) != null) {
				Car car = Car.fromStringToCar(data);
				carList.add(car);
			}
		} catch (IOException e) {
			carList = new ArrayList<>();
		}
		return carList;
	}

	private int generateId() {
		return ++currentId;
	}

	@Override
	public Car searchCarById(int id) {
		Car c = new Car();
		for (Car element : carList) {
			if (element.getId() == id) {
				c = element;
			}
		}
		return c;
	}
	
	@Override
	public List<String> getAllCarNames(){
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
