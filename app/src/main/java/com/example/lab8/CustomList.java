package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount() {

        return cities.size();
    }

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     *             If the city already exists, throw an exception
     *             If the city does not exist, add it to the list
     * @throws IllegalArgumentException This is thrown if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }



    /**
     * This returns whether or not the city is in the list
     * @param city This is the city to check
     *             If the city is in the list, return true
     *             If the city is not in the list, return false
     * @return Return boolean value whether or not the city is in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list
     * @param city This is the city to delete
     *             If the city is not in the list, throw an exception
     *             If the city is in the list, remove it
     * @throws IllegalArgumentException This is thrown if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns the number of cities in the list
     * @return  the total number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}



