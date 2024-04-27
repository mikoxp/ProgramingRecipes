package org.moles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Test {
    private String a;
    private Integer b;
    private int c;
    private boolean d;
    private Boolean e;

    private Test f;

}
