package org.fteller.model.areas;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/18/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "district")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter@Setter int id;
    private @Getter@Setter String name;

    //this is to map the one to many relationship between district and upazillas
    @OneToMany(mappedBy = "district",cascade = CascadeType.ALL)
    private @Getter@Setter
    Set<Upazilla> upazillas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "division_id")
    private @Getter@Setter Division division;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        District district = (District) o;

        if (getId() != district.getId()) return false;
        return getName() != null ? getName().equals(district.getName()) : district.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    public void addUpazillas(@NonNull Upazilla... upazillas){
        this.getUpazillas().addAll(Arrays.asList(upazillas));
    }
}
