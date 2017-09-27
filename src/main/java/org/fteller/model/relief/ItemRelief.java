package org.fteller.model.relief;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Abdullah Al Amin on 9/26/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
public class ItemRelief extends ReliefType {
    private @Getter@Setter int amountInUnit;
}
