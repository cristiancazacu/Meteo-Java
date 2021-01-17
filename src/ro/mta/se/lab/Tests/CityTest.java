package ro.mta.se.lab.Tests;

import org.junit.Assert;
import ro.mta.se.lab.DataModels.City;

import static org.junit.Assert.*;


//Test clasa independenta, 100%
public class CityTest {
    private City city;
    //662118	Zvoriştea	47.833328	26.283331	RO

    @org.junit.Before
    public void setUp() throws Exception {
        city = new City("662118", "Zvoriştea","47.833328","26.283331", "RO");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void TestgetLon() {
        Assert.assertEquals(Double.parseDouble("26.283331"), city.getLon(), 0);
    }

    @org.junit.Test
    public void TestsetLon() {
        city.setLon(Double.parseDouble("0"));
        city.setLon(Double.parseDouble("26.283331"));
        Assert.assertEquals(Double.parseDouble("26.283331"), city.getLon(), 0);

    }

    @org.junit.Test
    public void testToString() {
        String expected_value = "662118 Zvoriştea 47.833328 26.283331 RO";
        assertEquals(expected_value, city.toString());
    }
}