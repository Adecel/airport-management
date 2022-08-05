package za.ac.cput.repository.department;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.department.Luggage;

import java.util.HashSet;
import java.util.Set;

public class LuggageRepository implements LRepository {

    public static LuggageRepository repository = null;
    private Set<Luggage> luggageDB = null;
    private LuggageRepository() {
        luggageDB = new HashSet<Luggage>();
    }

    public static LuggageRepository getRepository(){
        if (repository == null) {
            repository = new LuggageRepository();
        }
        return repository;
    }



    @Override
    public Luggage create(Luggage luggage) {
        boolean success = luggageDB.add(luggage) ;
        if(!success)
            return null;
        return luggage;
    }

    @Override
    public Luggage read(String luggageID) {
        Luggage luggage = luggageDB.stream()
                .filter(h -> h.getLuggageID().equals(luggageID))
                .findAny()
                .orElse(null);
        return luggage;
    }

    @Override
    public Luggage update(Luggage luggage) {
        Luggage oldLuggage = read(luggage.getLuggageID());
        if(oldLuggage!=null){
            luggageDB.remove(oldLuggage);
            luggageDB.add(luggage);
            return luggage;

        }
        return null;
    }

    @Override
    public boolean delete(String luggageID) {
        Luggage luggageToDelete=read(luggageID);
        if (luggageToDelete == null)
            return false;
        luggageDB.remove(luggageToDelete);
        return true;
    }
    @Override
    public Set<Luggage> getAll() {
        return luggageDB;
    }

}


