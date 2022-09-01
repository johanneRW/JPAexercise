package com.jpaex.services;

import com.jpaex.PersonsRepository;
import com.jpaex.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonServices implements IPersonServices {
    private PersonsRepository repo;

    public PersonServices(PersonsRepository repo) {
        this.repo = repo;
    }

    @Override
    public Set<Person> findAll() {
        Set<Person> set= new HashSet<>();
        repo.findAll().forEach(set::add);
        return set;
    }



        public Person save(Person object) {
            Person person = (Person) object;
            return repo.save(object);
    }

    @Override
    public void delete(Person person) {
        repo.delete(person);

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Person> findById(Long aLong) {
        return repo.findById(aLong);
    }
}
