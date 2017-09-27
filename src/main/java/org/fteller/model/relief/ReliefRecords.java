package org.fteller.model.relief;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fteller.model.areas.UnionParisad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/26/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
public class ReliefRecords {

    private @Getter@Setter int id;
    private  @Setter LocalDateTime timestamp ;
    private @Getter@Setter UnionParisad place;
    private @Getter@Setter Organization organization;
    private @Getter@Setter ReliefType type;


    public LocalDate getDate(){
       return timestamp.toLocalDate();
    }

}
