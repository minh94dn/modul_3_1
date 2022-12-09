package repository.impl;

import model.Facility;
import model.FacilityType;
import model.RentType;
import repository.BaseRepository;
import repository.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private final String SELECT_ALL = "select * from facility f join facility_type ft on ft.id_facility_type = f.id_facility_type join rent_type rt on rt.id_rent_type = f.id_rent_type order by id_facility;";
    private final String DELETE_FACILITY = "delete from facility where id_facility = ?;";
    private final String INSERT_VILLA = "insert into facility (`name`, area, cost, max_people, id_rent_type, id_facility_type, standard_room, description_other_convenience, pool_area, number_of_floors) value (?,?,?,?,?,?,?,?,?,?);";
    private final String INSERT_HOUSE = "insert into facility (`name`, area, cost, max_people, id_rent_type, id_facility_type, standard_room, description_other_convenience, number_of_floors) value (?,?,?,?,?,?,?,?,?);";
    private final String INSERT_ROOM = "insert into facility (`name`, area, cost, max_people, id_rent_type, id_facility_type, facility_free) value (?,?,?,?,?,?,?);";
    private final String FIND_BY_ID = "select * from facility where id_facility = ?";
    private final String UPDATE_VILLA = "update facility set id_facility = ?, `name` = ?, area =?, cost = ?, max_people =?, id_rent_type = ?, id_facility_type = ?, standard_room = ?, description_other_convenience = ?, pool_area = ?, number_of_floors = ? where id_facility = ?;";
    private final String UPDATE_HOUSE = "update facility set id_facility = ?, `name` = ?, area =?, cost = ?, max_people =?, id_rent_type = ?, id_facility_type = ?, standard_room = ?, description_other_convenience = ?, number_of_floors = ? where id_facility = ?;";
    private final String UPDATE_ROOM = "update facility set id_facility = ?, `name` = ?, area =?, cost = ?, max_people =?, id_rent_type = ?, id_facility_type = ?, facility_free = ? where id_facility = ?;";
    private final String SEARCH_FACIlITY = "select * from facility f join facility_type ft on ft.id_facility_type = f.id_facility_type join rent_type rt on rt.id_rent_type = f.id_rent_type where `name` like ? and cost = ? and name_rent_type like ?;";

    @Override
    public List<Facility> showAll() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idFacility = rs.getInt("id_facility");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int maxPeople = rs.getInt("max_people");
                int idRentType = rs.getInt("id_rent_type");
                int idFacilityType = rs.getInt("id_facility_type");
                String standardRoom = rs.getString("standard_room");
                String description_other_convenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloors = rs.getInt("number_of_floors");
                String facilityFree = rs.getString("facility_free");
                String nameFacilityType = rs.getString("name_facility_type");
                String nameRentType = rs.getString("name_rent_type");
                FacilityType facilityType = new FacilityType(nameFacilityType);
                RentType rentType = new RentType(nameRentType);
                Facility facility = new Facility(idFacility, name, area, cost, maxPeople, idRentType, idFacilityType, standardRoom, description_other_convenience, poolArea, numberOfFloors, facilityFree, facilityType, rentType);
                facilityList.add(facility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_FACILITY);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement ps = null;
        try {
            if (facility.getFacilityTypeId() == 1) {
                ps = connection.prepareStatement(INSERT_VILLA);
                ps.setString(1, facility.getName());
                ps.setInt(2, facility.getArea());
                ps.setDouble(3, facility.getCost());
                ps.setInt(4, facility.getMaxPeople());
                ps.setInt(5, facility.getRentTypeId());
                ps.setInt(6, facility.getFacilityTypeId());
                ps.setString(7, facility.getStandardRoom());
                ps.setString(8, facility.getDescriptionOtherConvenience());
                ps.setDouble(9, facility.getPoolArea());
                ps.setInt(10, facility.getNumberOfFloors());
            } else if (facility.getFacilityTypeId() == 2) {
                ps = connection.prepareStatement(INSERT_HOUSE);
                ps.setString(1, facility.getName());
                ps.setInt(2, facility.getArea());
                ps.setDouble(3, facility.getCost());
                ps.setInt(4, facility.getMaxPeople());
                ps.setInt(5, facility.getRentTypeId());
                ps.setInt(6, facility.getFacilityTypeId());
                ps.setString(7, facility.getStandardRoom());
                ps.setString(8, facility.getDescriptionOtherConvenience());
                ps.setInt(9, facility.getNumberOfFloors());
            } else {
                ps = connection.prepareStatement(INSERT_ROOM);
                ps.setString(1, facility.getName());
                ps.setInt(2, facility.getArea());
                ps.setDouble(3, facility.getCost());
                ps.setInt(4, facility.getMaxPeople());
                ps.setInt(5, facility.getRentTypeId());
                ps.setInt(6, facility.getFacilityTypeId());
                ps.setString(7, facility.getFacilityFree());
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Facility findByID(int idSearch) {
        Facility facility = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
            ps.setInt(1, idSearch);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idFacility = rs.getInt("id_facility");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int maxPeople = rs.getInt("max_people");
                int idRentType = rs.getInt("id_rent_type");
                int idFacilityType = rs.getInt("id_facility_type");
                String standardRoom = rs.getString("standard_room");
                String description_other_convenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloors = rs.getInt("number_of_floors");
                String facilityFree = rs.getString("facility_free");
                facility = new Facility(idFacility, name, area, cost, maxPeople, idRentType, idFacilityType, standardRoom, description_other_convenience, poolArea, numberOfFloors, facilityFree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facility;
    }

    @Override
    public boolean edit(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement ps = null;
        try {
            if (facility.getFacilityTypeId() == 1) {
                ps = connection.prepareStatement(UPDATE_VILLA);
                ps.setString(1, facility.getName());
                ps.setInt(2, facility.getArea());
                ps.setDouble(3, facility.getCost());
                ps.setInt(4, facility.getMaxPeople());
                ps.setInt(5, facility.getRentTypeId());
                ps.setInt(6, facility.getFacilityTypeId());
                ps.setString(7, facility.getStandardRoom());
                ps.setString(8, facility.getDescriptionOtherConvenience());
                ps.setDouble(9, facility.getPoolArea());
                ps.setInt(10, facility.getNumberOfFloors());
                ps.setInt(11, facility.getId());
            } else if (facility.getFacilityTypeId() == 2) {
                ps = connection.prepareStatement(UPDATE_HOUSE);
                ps.setString(1, facility.getName());
                ps.setInt(2, facility.getArea());
                ps.setDouble(3, facility.getCost());
                ps.setInt(4, facility.getMaxPeople());
                ps.setInt(5, facility.getRentTypeId());
                ps.setInt(6, facility.getFacilityTypeId());
                ps.setString(7, facility.getStandardRoom());
                ps.setString(8, facility.getDescriptionOtherConvenience());
                ps.setInt(9, facility.getNumberOfFloors());
                ps.setInt(10, facility.getId());
            } else {
                ps = connection.prepareStatement(UPDATE_ROOM);
                ps.setString(1, facility.getName());
                ps.setInt(2, facility.getArea());
                ps.setDouble(3, facility.getCost());
                ps.setInt(4, facility.getMaxPeople());
                ps.setInt(5, facility.getRentTypeId());
                ps.setInt(6, facility.getFacilityTypeId());
                ps.setString(7, facility.getFacilityFree());
                ps.setInt(8, facility.getId());
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Facility> search(String searchName, double searchCost, String searchRentType) {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH_FACIlITY);
            ps.setString(1, "%" + searchName +"%");
            ps.setDouble(2, searchCost);
            ps.setString(3, ("%" + searchRentType +"%"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int idFacility = rs.getInt("id_facility");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int maxPeople = rs.getInt("max_people");
                int idRentType = rs.getInt("id_rent_type");
                int idFacilityType = rs.getInt("id_facility_type");
                String standardRoom = rs.getString("standard_room");
                String description_other_convenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloors = rs.getInt("number_of_floors");
                String facilityFree = rs.getString("facility_free");
                String nameFacilityType = rs.getString("name_facility_type");
                String nameRentType = rs.getString("name_rent_type");
                FacilityType facilityType = new FacilityType(nameFacilityType);
                RentType rentType = new RentType(nameRentType);
                Facility facility = new Facility(idFacility, name, area, cost, maxPeople, idRentType, idFacilityType, standardRoom, description_other_convenience, poolArea, numberOfFloors, facilityFree, facilityType, rentType);
                facilityList.add(facility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }
}
