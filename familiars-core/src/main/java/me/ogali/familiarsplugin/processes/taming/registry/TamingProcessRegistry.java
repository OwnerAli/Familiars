package me.ogali.familiarsplugin.processes.taming.registry;

import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TamingProcessRegistry {

    private final Set<AbstractTamingProcess> tamingProcessSet = new HashSet<>();

    public void registerTamingProcess(AbstractTamingProcess abstractTamingProcess) {
        tamingProcessSet.add(abstractTamingProcess);
    }

    public void unregisterTamingProcessById(String id) {
        tamingProcessSet.removeIf(abstractTamingProcess -> abstractTamingProcess.getId().equals(id));
    }

    public Optional<AbstractTamingProcess> getTamingProcessById(String id) {
        return tamingProcessSet.stream()
                .filter(abstractTamingProcess -> abstractTamingProcess.getId().equals(id))
                .findFirst();
    }

    public Set<AbstractTamingProcess> getTamingProcessSet() {
        return tamingProcessSet;
    }

}
