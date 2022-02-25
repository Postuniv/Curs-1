package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Piesa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPiesaRepository {
    private Map<String, Piesa> storage = new HashMap<>();

    public void create(Piesa piesa) {
        if (storage.containsKey(piesa.getId())) {
            throw new RuntimeException("Exista deja o piesa cu id-ul " + piesa.getId());
        }

        this.storage.put(piesa.getId(), piesa);
    }

    public List<Piesa> read() {
        return new ArrayList<>(storage.values());
    }

    public void update(Piesa piesa) {
        if (!storage.containsKey(piesa.getId())) {
            throw new RuntimeException("Nu exista nicio piesa cu id-ul " + piesa.getId());
        }

        this.storage.put(piesa.getId(), piesa);
    }

    public void delete(String idPiesa) {
        if (!storage.containsKey(idPiesa)) {
            throw new RuntimeException("Nu exista nicio piesa cu id-ul " + idPiesa);
        }

        this.storage.remove(idPiesa);
    }
}
