package repository.impl;

import model.FacilityType;
import repository.BaseRepository;
import repository.IFacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepository implements IFacilityTypeRepository {
    private final String SELECT_ALL = "select * from facility_type;";
    @Override
    public List<FacilityType> showAll() {
        List<FacilityType> facilityTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_facility_type");
                String name = rs.getString("name_facility_type");
                FacilityType facilityType = new FacilityType(id, name);
                facilityTypeList.add(facilityType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityTypeList;
    }
}
