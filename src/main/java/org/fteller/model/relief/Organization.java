package org.fteller.model.relief;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Abdullah Al Amin on 9/26/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private @Getter@Setter String name;
    private @Getter@Setter String description;
    private @Getter@Setter String  nameAcronym;
    private @Getter@Setter OrganizationLevel orgLevel;
}
