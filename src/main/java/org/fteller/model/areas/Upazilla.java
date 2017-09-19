package org.fteller.model.areas;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/18/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "upazilla")
public class Upazilla {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter@Setter int id;
    private @Getter@Setter String name;

    @OneToMany(mappedBy = "upazilla",cascade = CascadeType.ALL)
    private @Getter@Setter Set<UnionParisad> unionParisads;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private @Getter@Setter District district;

    public void addUnions(@NonNull UnionParisad... unionParisad){
        unionParisads.addAll(Arrays.asList(unionParisad));
    }

}
