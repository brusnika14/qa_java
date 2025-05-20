package com.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy

    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        // Создали мок объект Feline
        //feline = mock(Feline.class);
        // Создали экземпляра Lion с мок объектом Feline
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        // Проверка, что у самца есть грива
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        // По умолчанию spy вызывает реальный метод, который возвращает 1
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFoodReturnsCorrectPredatorFood() throws Exception {
        // Arrange
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самец", feline);

        // Настраиваем мок для возврата реального списка еды хищника
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Act
        List<String> food = lion.getFood();

        // Assert
        assertEquals("Должен вернуться корректный список еды для хищника",
                List.of("Животные", "Птицы", "Рыба"),
                food);
    }
    @Test
    public void shouldThrowExceptionForInvalidSex() {
        Feline feline = new Feline();
        // Проверяем, что при передаче некорректного значения пола будет выброшено исключение
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });
        // Проверяем, что сообщение исключения соответствует ожидаемому
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}