package repository;

import model.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> showAll();

    boolean delete(int id);

    boolean add(Facility facility);

    Facility findByID(int idSearch);

    boolean edit(Facility facility);

   List<Facility> search(String searchName, double searchCost, String searchRentType);
}
