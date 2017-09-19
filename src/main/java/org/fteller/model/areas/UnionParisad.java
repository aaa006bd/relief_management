package org.fteller.model.areas;

import lombok.*;

import javax.persistence.*;

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

}
