package com.avi.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplMockTest {

    // Test using Mock
    @Test
    void testFindGreatestFromAllData(){
        DataService dataServiceMock = mock(DataService.class);
        //dataServiceMock.retrieveAllData() => new int[]{24,44,55};
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24,44,55});

        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        int greatestValueFromAllData = business.findGreatestFromAllData();
        assertEquals(55, greatestValueFromAllData);
    }

    @Test
    void testFindGreatestFromAllData_WithOneValue(){

        //mocking
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{22});
        //simple creating obj, calling method
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
        int greatestFromAllData = someBusiness.findGreatestFromAllData();
        assertEquals(22,greatestFromAllData);
    }
}