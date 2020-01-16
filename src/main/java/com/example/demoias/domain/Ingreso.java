package com.example.demoias.domain;


import com.google.common.base.Preconditions;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public class Ingreso {
    private final BigDecimal value;

    private Ingreso(BigDecimal value) {
        BigDecimal nnValue = Preconditions.checkNotNull(value);
        Preconditions.checkArgument(nnValue.compareTo(BigDecimal.ZERO) >= 0);
        this.value = nnValue;
    }
}
