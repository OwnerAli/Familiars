package me.ogali.familiarsplugin.familiars.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractFamiliar {

    private String displayName;
    private double speed;
    private double health;

    public AbstractFamiliar(String displayName) {
        this.displayName = displayName;
    }

}
