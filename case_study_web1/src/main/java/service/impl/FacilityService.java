package service.impl;

import model.Facility;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository iFacilityRepository = new FacilityRepository();

    @Override
    public List<Facility> showAll() {
        return iFacilityRepository.showAll();
    }

    @Override
    public boolean delete(int id) {
        return iFacilityRepository.delete(id);
    }

    @Override
    public boolean add(Facility facility) {
        return iFacilityRepository.add(facility);
    }

    @Override
    public Facility findByID(int idSearch) {
        return iFacilityRepository.findByID(idSearch);
    }

    @Override
    public boolean edit(Facility facility) {
        return iFacilityRepository.edit(facility);
    }

    @Override
    public List<Facility> search(String searchName, double searchCost, String searchRentType) {
        return iFacilityRepository.search(searchName, searchCost, searchRentType);
    }


}
