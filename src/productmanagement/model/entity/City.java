package productmanagement.model.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class City {
	private int id;
	private String name;

	public City() {

	}

	public City(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return id + "," + name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static City fromStringToCity(String str) {
        String[] parts = str.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        return new City(id, name);
    }

	@SuppressWarnings("unused")
	private List<City> loadCityList() {
		List<City> cityList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("City.bin"))) {
			String data;
			while ((data = reader.readLine()) != null) {
				City user = City.fromStringToCity(data);
				cityList.add(user);
			}
		} catch (IOException e) {
			cityList = new ArrayList<>();
		}
		return cityList;
	}
}
