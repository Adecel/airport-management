package za.ac.cput.repository.impl;

import za.ac.cput.domain.entity.RunWay;

import java.util.HashSet;
import java.util.Set;

//219383448 KISSIMBA NYEMBO ISAAC
public class RunwayRepository implements RRepository{

    public static RunwayRepository repository = null;
    private Set<RunWay> runwayDB = null;
    private RunwayRepository() {
        runwayDB = new HashSet<RunWay>();
    }

    public static RunwayRepository getRepository(){
        if (repository == null) {
            repository = new RunwayRepository();
        }
        return repository;
    }



    @Override
    public RunWay create(RunWay runWay) {
        boolean success = runwayDB.add(runWay) ;
        if(!success)
            return null;
        return runWay;
    }

    @Override
    public RunWay read(String runwayNumber) {
        RunWay runWay = runwayDB.stream()
                .filter(h -> h.getRunwayNumber().equals(runwayNumber))
                .findAny()
                .orElse(null);
        return runWay;
    }

    @Override
    public RunWay update(RunWay runWay) {
        RunWay oldRunway= read(runWay.getRunwayNumber());
        if(oldRunway!=null){
            runwayDB.remove(oldRunway);
            runwayDB.add(runWay);
            return runWay;

        }
        return null;
    }

    @Override
    public boolean delete(String runwayNumber) {
        RunWay runWayToDelete=read(runwayNumber);
        if (runWayToDelete == null)
            return false;
        runwayDB.remove(runWayToDelete);
        return true;
    }
    @Override
    public Set<RunWay> getAll() {

        return runwayDB;
    }
}
