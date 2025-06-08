package com.avi.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

    @Test
    void testFindGreatestFromAllData(){
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int greatestValueFromAllData = business.findGreatestFromAllData();
        assertEquals(556, greatestValueFromAllData);
    }
    @Test
    void testFindGreatestFromAllData_WithOneValue(){
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int greatestValueFromAllData = business.findGreatestFromAllData();
        assertEquals(23, greatestValueFromAllData);
    }
}

class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{23, 44, 556, 54};
    }
}
    class DataServiceStub2 implements DataService{

        @Override
        public int[] retrieveAllData() {
            return new int[]{23};
        }
}