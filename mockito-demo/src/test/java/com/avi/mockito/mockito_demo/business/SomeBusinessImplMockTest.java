package com.avi.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    //step2: with mock annotation
    @Mock
    private DataService dataServiceMock;
    @InjectMocks
    private SomeBusinessImpl business;

    // Test using Mock annotation
    @Test
    void testFindGreatestFromAllData(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24,44,55});
        int greatestValueFromAllData = business.findGreatestFromAllData();
        assertEquals(55, greatestValueFromAllData);
    }

    //step1: without mock annotation
    @Test
    void testFindGreatestFromAllData_WithOneValue(){

        //creating mock manually
        DataService dataServiceMock = mock(DataService.class);
        //dataServiceMock.retrieveAllData() =>(return this int[]) new int[]{24,44,55};
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{22});
        //simple creating obj, calling method ====> injecting mock manually
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
        int greatestFromAllData = someBusiness.findGreatestFromAllData();
        assertEquals(22,greatestFromAllData);
    }
}