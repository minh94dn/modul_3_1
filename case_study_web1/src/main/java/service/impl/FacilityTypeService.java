package service.impl;

import model.FacilityType;
import repository.IFacilityTypeRepository;
import repository.impl.FacilityTypeRepository;
import service.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    private IFacilityTypeRepository iFacilityTypeRepository = new FacilityTypeRepository();
    @Override
    public List<FacilityType> showAll() {
        return iFacilityTypeRepository.showAll();
    }
}
