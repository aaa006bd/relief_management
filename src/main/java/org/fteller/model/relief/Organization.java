package org.fteller.model.relief;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/26/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private @Getter@Setter String name;
    private @Getter@Setter String description;
    private @Getter@Setter String  nameAcronym;
    private @Getter@Setter OrganizationLevel orgLevel;

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL)
    private @Getter@Setter Set<ReliefRecords> reliefRecords;

    public void addReliefRecords(@NonNull ReliefRecords... records){
        reliefRecords.addAll(Arrays.asList(records));
    }
}
