package me.ogali.familiarsplugin.familiars.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;

@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractFamiliar {

    private String displayName;
    private AbstractTamingProcess tamingProcess;
    private double speed;
    private double health;

    public AbstractFamiliar(String displayName) {
        this.displayName = displayName;
    }

}
