package org.fteller.model.areas;

import lombok.*;
import org.fteller.model.relief.ReliefRecords;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/18/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "union_parisad")
public class UnionParisad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  @Getter@Setter int id;
    private  @Getter@Setter String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upazilla_id")
    private @Getter@Setter Upazilla upazilla;

    @OneToMany(mappedBy = "place",cascade = CascadeType.MERGE)
    private @Getter@Setter Set<ReliefRecords> reliefRecords;

}
