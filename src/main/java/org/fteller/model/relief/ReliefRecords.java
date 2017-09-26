package org.fteller.model.relief;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fteller.model.areas.UnionParisad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/26/2017.
 */
@NoArgsConstructor

public class ReliefRecords {

    private @Getter@Setter int id;
    private  @Setter LocalDateTime timestamp ;
    private @Getter@Setter UnionParisad place;
    private Set<Organization> organizations;


    public LocalDate getDate(){
       return timestamp.toLocalDate();
    }

}
