package com.example.lab8;


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
        public void deleteCityTest(){
            list = MockCityList();
            list.add(new City("Edmonton", "AB"));
            int listSize = list.getCount();
            list.delete(new City("Edmonton", "AB"));
            assertEquals(list.getCount(),listSize-1);

        }


}
