package model;

import utils.Constants;

import java.util.Map;
import java.util.TreeMap;

public class Author extends Person {
    private String country;

    public Author(Integer id, String name, String country) {
        super(id, name);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String ethnicity) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


}
