package org.fteller.model.areas.repositories;

import org.fteller.model.areas.Division;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Abdullah Al Amin on 9/19/2017.
 */
public interface DivisionRepository extends JpaRepository<Division,Integer> {
    Division findByName(String name);
}
