package service;

import model.Facility;
import model.FacilityType;

import java.util.List;

public interface IFacilityService {
    List<Facility> showAll();

    boolean delete(int id);

    boolean add(Facility facility);

    Facility findByID(int idSearch);

    boolean edit(Facility facility);

  List<Facility> search(String searchName, double searchCost, String searchRentType);
}
