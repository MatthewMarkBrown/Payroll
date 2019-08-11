package ac.za.Payroll.repository.demography.impl;

import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepositoryImpl repository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }

    private Gender findGender(String genderId) {
        return this.genders.stream()
                .filter(gender -> gender.getGenderId().trim().equals(genderId))
                .findAny()
                .orElse(null);
    }

    public static GenderRepositoryImpl getRepository(){
        if (repository == null) repository = new GenderRepositoryImpl();
        return repository;
    }


    public Gender create(Gender gender){
        this.genders.add(gender);
        return gender;
    }

    public Gender read(final String genderId){
        Gender gender = findGender(genderId);
        return gender;
    }

    public void delete(String genderId) {
        Gender gender = findGender(genderId);
        if (gender != null) this.genders.remove(gender);
    }

    public Gender update(Gender gender){
        Gender toDelete = findGender(gender.getGenderId());
        if(toDelete != null) {
            this.genders.remove(toDelete);
            return create(gender);
        }
        return null;
    }

    public Set<Gender> getAll(){
        return this.genders;
    }

}
