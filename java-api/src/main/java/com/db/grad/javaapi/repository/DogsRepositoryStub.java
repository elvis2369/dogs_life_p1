package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogsRepositoryStub {
    private ArrayList<Dog> itsDogs = new ArrayList<>();

    private long addDog(Dog theDog) {
        long result = 0;
        itsDogs.add(theDog);
        result = itsDogs.size();
        theDog.setId(result);
        return result;
    }

    //@Override
    public Dog findById(long id) {
        Dog result = null;

        for (Dog theDog : itsDogs)
            if (theDog.getId() == id) {
                result = theDog;
                break;
            }

        return result;
    }

    public Dog getDogByName(String dogName) {
        ArrayList<Dog> result = new ArrayList<>();

        for (Dog theDog : itsDogs)
            if (theDog.getName().equalsIgnoreCase(dogName)) {
                result.add(theDog);
            }

        if (result.size() > 1 || result.isEmpty()) {
            return null;
        }


        return result.get(0);
    }

    Dog getDogByID(long id) {

        for (Dog dog : itsDogs) {
            if (dog.getId() == id) {
                return dog;
            }

        }
        return null;
    }

    long updateDogDetails(Dog dog) {
        for (int i = 0; i < itsDogs.size(); ++i)
            if (itsDogs.get(i).getName().equalsIgnoreCase(dog.getName())) {
                itsDogs.get(i).setId(dog.getId());
                return dog.getId();
            } else if (itsDogs.get(i).getId() == dog.getId()) {
                itsDogs.get(i).setName(dog.getName());
                return dog.getId();
            }

        return -1;
    }

    //@Override
    public List<Dog> findByName(Dog aDog) {
        ArrayList<Dog> result = new ArrayList<>();

        for (Dog theDog : itsDogs)
            if (theDog.getName().equalsIgnoreCase(aDog.getName())) {
                result.add(theDog);
            }

        return result;
    }

    //@Override
    public Dog save(Dog aDog) {
        Dog retrievedDog = null;
        Dog result = null;

        for (Dog theDog : itsDogs)
            if (theDog.getId() == aDog.getId()) {
                retrievedDog = theDog;
                retrievedDog.setName(aDog.getName());
                //result = retrievedDog.getId();
                break;
            }
        //if (retrievedDog == null)
            //result = addDog(aDog);

        return result;
    }

    //@Override
    public void delete(Dog aDog) {
        boolean result = false;
        long initialSize = itsDogs.size();

        itsDogs.removeIf(dog -> dog.getId() == aDog.getId());
        result = initialSize != itsDogs.size();

    }

    //@Override
    public long count() {
        return this.itsDogs.size();
    }

    //@Override
    public boolean existsById(long id) {
        boolean result = false;

        for (Dog theDog : itsDogs)
            if (theDog.getId() == id) {
                result = true;
                //exists by id
                break;
            }

        return result;
    }

    //@Override
    public void deleteAll() {
        itsDogs.clear();
    }

}
