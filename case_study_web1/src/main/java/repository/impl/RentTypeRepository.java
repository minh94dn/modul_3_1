package repository.impl;

import model.RentType;
import repository.BaseRepository;
import repository.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    private final String SELECT_ALL = "select * from rent_type;";
    @Override
    public List<RentType> showAll() {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_rent_type");
                String name = rs.getString("name_rent_type");
                RentType rentType = new RentType(id, name);
                rentTypeList.add(rentType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }
}
