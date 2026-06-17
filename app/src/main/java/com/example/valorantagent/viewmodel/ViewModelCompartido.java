package com.example.valorantagent.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.valorantagent.modelos.Agente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewModelCompartido extends ViewModel {

    private final MutableLiveData<List<Agente>> team =
            new MutableLiveData<>(new ArrayList<Agente>());

    private final MutableLiveData<Agente> selectedAgent =
            new MutableLiveData<>();

    public LiveData<List<Agente>> getTeam() {
        return team;
    }

    public LiveData<Agente> getSelectedAgent() {
        return selectedAgent;
    }

    public void setSelectedAgent(Agente agent) {
        selectedAgent.setValue(agent);
    }

    public boolean addAgent(Agente a) {
        List<Agente> current = new ArrayList<>(team.getValue());
        for (Agente existing : current) {
            if (existing.getId() == a.getId()) {
                return false;
            }
        }
        current.add(a);
        team.setValue(current);
        return true;
    }

    public void removeAgent(Agente a) {
        List<Agente> current = new ArrayList<>(team.getValue());
        Iterator<Agente> it = current.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == a.getId()) {
                it.remove();
                break;
            }
        }
        team.setValue(current);
    }
}
