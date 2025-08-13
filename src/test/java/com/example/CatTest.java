package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;


@Test
    public void getSoundReturnsMeow() {
    Cat cat = new Cat(feline);
    String actualResult = cat.getSound();
    assertEquals("Мяу", actualResult);
}

    @Test
    public void getFoodReturnsList() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    public void getFoodReturnsException() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка еды"));
        assertThrows(Exception.class, () -> cat.getFood());
    }


}



