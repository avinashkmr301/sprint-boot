package com.avi.mockito.mockito_demo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    @Test
    void simpleMockTest(){
        List listMock = mock(List.class);
        //listMock.size() => 3
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturns(){

        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(5);

        assertEquals(2,listMock.size());
        assertEquals(5,listMock.size());
    }

    @Test
    void specificParameterMock(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("someString");

        assertEquals("someString",listMock.get(0));
        assertEquals(null,listMock.get(1));
    }

    @Test
    void genericParameter(){
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("someOtherString");

        assertEquals("someOtherString",listMock.get(23));
        assertEquals("someOtherString",listMock.get(1));
    }
}
