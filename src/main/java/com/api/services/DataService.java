package com.api.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DataService implements IDataService {
   private List<String> provideStrings(){
	   String[] strings= {"Raja","Ram","Rahim","Ajay","Krishna","Jerry"};
	   return  Arrays.asList(strings);
   }

     @Override
    public List<String> getPeople() {
	// TODO Auto-generated method stub
	     return provideStrings();
    }
   
   
}
