package org.fteller.model.relief;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fteller.model.areas.UnionParisad;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/26/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReliefRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter@Setter int id;
    private  @Setter LocalDateTime timestamp ;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "union_parisad_id")
    private @Getter@Setter UnionParisad place;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private @Getter@Setter Organization organization;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "relief_type_id")
    private @Getter@Setter ReliefType type;


    public LocalDate getDate(){
       return timestamp.toLocalDate();
    }

}
