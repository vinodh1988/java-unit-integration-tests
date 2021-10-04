package com.api.services;

import java.util.List;

import com.api.entity.Person;

public interface IDataService {
    public List<String> getPeople();
    public List<Person> getPeople2();
}
