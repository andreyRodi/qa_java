package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FelineTest {

    @Test
    void eatMeatReturnsPredatorFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void getFamilyReturnsCorrectString() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }





    @Test
    void getFoodReturnsPredatorFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void eatMeatThrowsExceptionIfAnimalThrows() throws Exception {
        Feline felineSpy = Mockito.spy(new Feline());
        when(felineSpy.getFood("Хищник")).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        assertThrows(Exception.class, felineSpy::eatMeat);
    }

    @Test
    void getFoodThrowsExceptionIfAnimalThrows() throws Exception {
        Feline felineSpy = Mockito.spy(new Feline());
        when(felineSpy.getFood()).thenThrow(new Exception("Ошибка еды"));
        assertThrows(Exception.class, felineSpy::getFood);
    }
}
