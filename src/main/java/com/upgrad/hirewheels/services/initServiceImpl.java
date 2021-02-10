package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class initServiceImpl implements initService {

    @Autowired
    RoleDao userRoleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    Vehicle_categoryDao vehicleCategoryDao;

    @Autowired
    Vehicle_subcategoryDao vehicleSubCategoryDao;

    @Autowired
    CityDao cityDao;

    @Autowired
    Fuel_typeDao fuelTypeDao;

    @Autowired
    LocationDao locationDao;

    public void start() {
        addUserRole();
        addUsers();
        addVehicleCategory();
        addCity();
        addFuelType();
        addLocation();
        addVehicleSubCategory();
    }

    private void addCity() {
        City c=new City();
        c.setCityId(1);
        c.setCityName("Mumbai");
        cityDao.save(c);
    }

    private void addLocation() {
        Location location1 = new Location();
        location1.setCity(cityDao.findById(1));
        location1.setLocationId(1);
        location1.setLocationName("Worli");
        location1.setLocationAddress("Dr E Moses Rd, Worli Naka, Upper Worli");
        location1.setPincode("400018");
        locationDao.save(location1);

        Location location2 = new Location();
        location2.setCity(cityDao.findById(1));
        location2.setLocationId(2);
        location2.setLocationName("Chembur");
        location2.setLocationAddress("Optic Complex");
        location2.setPincode("400019");
        locationDao.save(location2);

        Location location3 = new Location();
        location3.setCity(cityDao.findById(1));
        location3.setLocationId(3);
        location3.setLocationName("Powai");
        location3.setLocationAddress("Hiranandani Tower");
        location3.setPincode("400017");
        locationDao.save(location3);
    }

    private void addFuelType() {

        Fuel_type f1=new Fuel_type();
        f1.setFuelType("Patrol");
        fuelTypeDao.save(f1);

        Fuel_type f2=new Fuel_type();
        f2.setFuelType("Diesel");
        fuelTypeDao.save(f2);
    }

    private void addVehicleCategory() {

        Vehicle_category vc1=new Vehicle_category();
        vc1.setVehicleCategoryId(10);
        vc1.setVehicleCategoryName("CAR");
        vehicleCategoryDao.save(vc1);

        Vehicle_category vc2=new Vehicle_category();
        vc2.setVehicleCategoryId(11);
        vc2.setVehicleCategoryName("BIKE");
        vehicleCategoryDao.save(vc2);
    }

    private void addVehicleSubCategory() {



        Vehicle_subcategory vs1=new Vehicle_subcategory();
        vs1.setVehicleCategory(vehicleCategoryDao.findById(10));
        vs1.setVehicleSubcategoryId(111);
        vs1.setVehicleSubcategoryName("SUV");
        vs1.setPricePerDay(300);
        vehicleSubCategoryDao.save(vs1);

        Vehicle_subcategory vs2=new Vehicle_subcategory();
        vs2.setVehicleCategory(vehicleCategoryDao.findById(10));
        vs2.setVehicleSubcategoryId(112);
        vs2.setVehicleSubcategoryName("SEDAN");
        vs2.setPricePerDay(350);
        vehicleSubCategoryDao.save(vs2);

        Vehicle_subcategory vs3=new Vehicle_subcategory();
        vs3.setVehicleCategory(vehicleCategoryDao.findById(10));
        vs3.setVehicleSubcategoryId(113);
        vs3.setVehicleSubcategoryName("HATCHBACK");
        vs3.setPricePerDay(250);
        vehicleSubCategoryDao.save(vs3);

        Vehicle_subcategory vs4=new Vehicle_subcategory();
        vs4.setVehicleCategory(vehicleCategoryDao.findById(11));
        vs4.setVehicleSubcategoryId(114);
        vs4.setVehicleSubcategoryName("CRUISER");
        vs4.setPricePerDay(200);
        vehicleSubCategoryDao.save(vs4);

        Vehicle_subcategory vs5=new Vehicle_subcategory();
        vs5.setVehicleCategory(vehicleCategoryDao.findById(11));
        vs5.setVehicleSubcategoryId(115);
        vs5.setVehicleSubcategoryName("DIRT BIKE");
        vs5.setPricePerDay(200);
        vehicleSubCategoryDao.save(vs5);

        Vehicle_subcategory vs6=new Vehicle_subcategory();
        vs6.setVehicleCategory(vehicleCategoryDao.findById(11));
        vs6.setVehicleSubcategoryId(116);
        vs6.setVehicleSubcategoryName("SPORTS BIKE");
        vs6.setPricePerDay(150);
        vehicleSubCategoryDao.save(vs6);

    }

    private void addUserRole() {

        Role r1=new Role();
        r1.setRoleName("Admin");
        userRoleDao.save(r1);

        Role r2=new Role();
        r2.setRoleName("User");
        userRoleDao.save(r2);


    }

    private void addUsers() {

        User u=new User();
        u.setRole(userRoleDao.findById(1));
        u.setWalletMoney(12356);
        u.setPassword("admin@1234");
        u.setMobileNo("9922535251");
        u.setEmail("admin@gmail.com");
        u.setFirstName("Dattatray");
        u.setLastName("Admin");
        userDao.save(u);

    }
}
