package com.kodilla.sand;

import java.math.BigDecimal;

public final class Europe implements SandStorage {


    /**
     * Will not compile. Value is too big for a long variable
     *
     *
    @Override
    public long getSandBeansQuantity() {
        return 12345678901234567890L;                   // [1]
    }
    */

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("12345678901234567890");
        return sandQuantity;
    }

}