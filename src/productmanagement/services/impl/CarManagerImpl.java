package productmanagement.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import productmanagement.dao.CarDao;
import productmanagement.dao.impl.CarDaoImpl;
import productmanagement.model.dto.CarAddDTO;
import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;
import productmanagement.services.CarManager;

public class CarManagerImpl implements CarManager {
	private CarDao carDao = new CarDaoImpl();

	@Override
	public boolean addCar(CarAddDTO c) {
		Car car = new Car();
		car.setName(c.getName());
		car.setNumberOfSeats(c.getNumberOfSeats());
		car.setPrice(c.getPrice());
		car.setTypeCar(c.getTypeCar());
		car.setSize(c.getLength() + "-" + c.getWidth() + "-" + c.getHeight());
		car.setMomen(c.getMomen());
		car.setWattage(c.getWattage());
		car.setDescription(c.getDescription());
		car.setNumberOfAirBag(c.getNumberOfAirBag());
		car.setTotal(c.getTotal());
		car.setVersion(c.getVersion());
		car.setColor(c.getColor());
		return carDao.addCar(car);
	}

	@Override
	public boolean editCar(CarAddDTO c) {
		Car car = new Car();
		car.setId(c.getId());
		car.setName(c.getName());
		car.setNumberOfSeats(c.getNumberOfSeats());
		car.setPrice(c.getPrice());
		car.setTypeCar(c.getTypeCar());
		car.setSize(c.getLength() + "-" + c.getWidth() + "-" + c.getHeight());
		car.setMomen(c.getMomen());
		car.setWattage(c.getWattage());
		car.setDescription(c.getDescription());
		car.setNumberOfAirBag(c.getNumberOfAirBag());
		car.setTotal(c.getTotal());
		car.setVersion(c.getVersion());
		car.setColor(c.getColor());
		return carDao.updateCar(car);
	}

	@Override
	public boolean delCar(int id) {
		return carDao.deleteCar(id);
	}

	@Override
	public List<Car> searchCar(CarSearchDTO modelSearch) {
		List<Car> result = carDao.searchCar(modelSearch);
		return result;
	}

	@Override
	public List<Car> sortedCar() {
		List<Car> carList = carDao.getAllCars();
		carList.sort((c1, c2) -> Double.compare(c2.getId(), c1.getId()));
		return carList;
	}

	@Override
	public List<Car> sortedCarByPrice() {
		List<Car> carList = carDao.getAllCars();
		carList.sort((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
		return carList;
	}

	@Override
	public List<Car> sortedCarByNumberOfSeats() {
		List<Car> carList = carDao.getAllCars();
		carList.sort((c1, c2) -> Double.compare(c1.getNumberOfSeats(), c2.getNumberOfSeats()));
		return carList;
	}

	@Override
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}

	@Override
	public Car searchCarById(int id) {
		return carDao.searchCarById(id);
	}

	@Override
	public int statisticsTotal() {
		List<Car> carList = carDao.getAllCars();
		int totalCar = 0;
		for (Car element : carList) {
			totalCar += element.getTotal();
		}
		return totalCar;
	}
	
	@Override
	public boolean isCarExists(String carName) {
		for (Car car : carDao.getAllCars()) {
            if (car.getName().equals(carName)) {
                return true;
            }
        }
        return false;
	}
	
	@Override
	public List<String> getAllCarNames(List<Car> carList){
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            carNames.add(car.getName());
        }
        return carNames;
    }
	
	@Override
	public void loadCarNamesToComboBox(JComboBox<String> comboBox) {
        try {
            List<String> carNames = carDao.getAllCarNames();
            for (String name : carNames) {
                comboBox.addItem(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public Car getCarByName(String name) {
        for (Car car : carDao.getAllCars()) {
            if (car.getName().equals(name)) {
                return car;
            }
        }
        return null;
    }
}
