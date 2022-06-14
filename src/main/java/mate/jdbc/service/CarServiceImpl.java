package mate.jdbc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mate.jdbc.dao.CarDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Car;
import mate.jdbc.model.Driver;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        return carDao.get(id).get();
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        return carDao.delete(id);
    }

    public void addDriverToCar(final Driver driver, Car car) {
        List<Driver> drivers = new ArrayList<>(car.getDrivers());
        drivers.add(driver);
        car.setDrivers(Collections.unmodifiableList(drivers));
        carDao.update(car);
    }

    public void removeDriverFromCar(Driver driver, Car car) {
        List<Driver> drivers = new ArrayList<>(car.getDrivers());
        drivers.remove(driver);
        car.setDrivers(Collections.unmodifiableList(drivers));
        carDao.update(car);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        return carDao.getAllByDriver(driverId);
    }
}
