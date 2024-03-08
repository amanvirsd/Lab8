package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private  CustomList list;
     public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<City>());
        return list;
     }

     @Test
     public void addCityTest(){
         list = MockCityList();
         int listSize = list.getCount();
         list.add(new City("Edmonton", "AB"));
         assertEquals(list.getCount(),listSize+1);
     }



     @Test
        public void getCountTest(){
            list = MockCityList();
            assertEquals(list.getCount(),0);
        }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        // Create a single City instance to use for both adding and deleting.
        City edmonton = new City("Edmonton", "AB");
        list.add(edmonton); // Add the city to the list
        int listSizeBeforeDeletion = list.countCities(); // Get the size before deletion
        list.delete(edmonton); // Delete the same city object
        assertEquals(listSizeBeforeDeletion - 1, list.countCities()); // Assert the size has decreased by 1
    }



}
