package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    SuperFeline superFeline;

    @Test
    public void doesHaveManeReturnsException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Ни рыба, ни мясо"));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnsOne() {
        Lion lion = new Lion(superFeline);
        when(superFeline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void getFoodReturnsFoodList() throws Exception {
        Lion lion = new Lion(superFeline);
        when(superFeline.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFoodReturnsException() throws Exception {
        Lion lion = new Lion(superFeline);
        when(superFeline.getFood()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        assertThrows(Exception.class, lion::getFood);
    }


}

