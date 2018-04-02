package org.fteller.model.areas.controller;

import org.fteller.model.areas.District;
import org.fteller.model.areas.Division;
import org.fteller.model.areas.repositories.DistrictRepository;
import org.fteller.model.areas.repositories.DivisionRepository;
import org.fteller.model.areas.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Abdullah Al Amin on 4/1/2018.
 */
@RestController
@RequestMapping(path = "area")
public class AreaController {

    @Autowired
    AreaService service;
    @Autowired
    DivisionRepository repository;
    @Autowired
    DistrictRepository repository2;

    @GetMapping(path = "/alld",produces = "application/json")
    public List<Division> allDivisions(){
        return service.getDivisions();
    }

    @PostMapping(path="/saved" , consumes = "application/json")
    public void saveDivison(@RequestBody Division division){
        repository.save(division);
    }

    @PostMapping(path = "/savedist",consumes = "application/json")
    public void saveDistrict(@RequestBody District district){
        repository2.save(district);
    }
}
