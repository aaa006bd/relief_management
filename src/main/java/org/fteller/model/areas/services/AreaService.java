package org.fteller.model.areas.services;

import org.fteller.model.areas.District;
import org.fteller.model.areas.Division;
import org.fteller.model.areas.UnionParisad;
import org.fteller.model.areas.Upazilla;
import org.fteller.model.areas.repositories.DistrictRepository;
import org.fteller.model.areas.repositories.DivisionRepository;
import org.fteller.model.areas.repositories.UnionRepository;
import org.fteller.model.areas.repositories.UpazillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Abdullah Al Amin on 9/29/2017.
 */
@Component
public class AreaService {

    @Autowired
    private UnionRepository unionRepository;
    @Autowired
    private UpazillaRepository upazillaRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @Transactional
    public boolean createUnion(String name, Upazilla upazilla){
        List<UnionParisad> existing = unionRepository.findAll();
        boolean exists = existing.stream().anyMatch(unionp->unionp.getName().equals(name));
        if(!exists) {
            UnionParisad union = new UnionParisad();
            union.setName(name);
            union.setUpazilla(upazilla);
            unionRepository.save(union);
            return true;
        }else
            return false;
    }

    @Transactional
    public boolean createUpazilla(String name, District district){
        List<Upazilla> existing = upazillaRepository.findAll();
        boolean exists = existing.stream().anyMatch(upz->upz.getName().equals(name));
        if(!exists) {
            Upazilla upazilla = new Upazilla();
            upazilla.setName(name);
            upazilla.setDistrict(district);
            upazillaRepository.save(upazilla);
            return true;
        }else
            return false;
    }
    @Transactional
    public boolean createDistrict(String name, Division division){
        List<District> existing = districtRepository.findAll();
        boolean exists = existing.stream().anyMatch(district->district.getName().equals(name));
        if(!exists) {
            District district = new District();
            district.setName(name);
            district.setDivision(division);
            districtRepository.save(district);
            return true;
        }else
            return false;
    }
    @Transactional
    public boolean createDivison(String name){
        List<Division> existing = divisionRepository.findAll();
        boolean exists = existing.stream().anyMatch(unionp->unionp.getName().equals(name));
        if(!exists) {
            Division division = new Division();
            division.setName(name);
            divisionRepository.save(division);
            return true;
        }else
            return false;
    }


}
