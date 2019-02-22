package com.dao;

import com.entity.Person;

import java.util.List;

public interface PersonMapper {
    public List<Person> getPersonById_StringList(int id);

    public int insertPerson(Person p);

}
