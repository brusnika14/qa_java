package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {
    private final String expected = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT_FOR_The_Kitties = 1;
    private int kittensCount = 5;

    private Feline feline = new Feline();


    @Test
    public void testEatMeat() throws Exception {
        List<String> actualList = feline.eatMeat();
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        assertThat(
                actualList,
                is(expectedList)
        );
    }

    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        assertEquals("Ожидается другое семейство",
                expected, actual);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        assertEquals("Количество котят не соответствует ожидаемому",
                EXPECTED_KITTENS_COUNT_FOR_The_Kitties, actual);
    }

    @Test
    public void testTestGetKittens() {
        int actual = feline.getKittens(kittensCount);
        assertEquals("Количество котят не соответствует ожидаемому",
                kittensCount, actual);
    }
}