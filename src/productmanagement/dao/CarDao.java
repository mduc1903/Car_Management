package productmanagement.dao;

import java.util.List;

import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;

public interface CarDao {
    boolean addCar(Car car);

    boolean updateCar(Car car);

    boolean deleteCar(int id);

    List<Car> getAllCars();

    List<Car> searchCar(CarSearchDTO modelSearch);

    Car searchCarById(int id);
    
    public List<String> getAllCarNames();
}

