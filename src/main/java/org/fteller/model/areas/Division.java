package org.fteller.model.areas;

import lombok.*;
import org.fteller.model.areas.District;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/18/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter@Setter int id;
    private @Getter@Setter String name;

    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    private @Getter@Setter Set<District> districts;

    public void addDistricts(@NonNull District... districts){
        this.districts.addAll(Arrays.asList(districts));
    }

}
