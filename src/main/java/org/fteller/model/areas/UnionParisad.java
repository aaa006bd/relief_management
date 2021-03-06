package org.fteller.model.areas;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.fteller.model.relief.ReliefRecords;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/18/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "union_parisad")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UnionParisad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  @Getter@Setter int id;
    private  @Getter@Setter String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upazilla_id")
    private @Getter@Setter Upazilla upazilla;

    @OneToMany(mappedBy = "place",cascade = CascadeType.MERGE)
    private @Getter@Setter
    Set<ReliefRecords> reliefRecords;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnionParisad that = (UnionParisad) o;

        if (getId() != that.getId()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
