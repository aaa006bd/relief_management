package org.fteller.model.areas;

import lombok.*;

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
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter@Setter int id;
    private @Getter@Setter String name;

    //this is to map the one to many relationship between district and upazillas
    @OneToMany(mappedBy = "district",cascade = CascadeType.ALL)
    private @Getter@Setter Set<Upazilla> upazillas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "division_id")
    private @Getter@Setter Division division;



    public void AddUpazillas(@NonNull Upazilla... upazillas){
        this.getUpazillas().addAll(Arrays.asList(upazillas));
    }
}
