package models.products;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractProduct {
    @Getter
    @Setter
    private String description;
}
