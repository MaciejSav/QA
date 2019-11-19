package com.jsystems.qa.qajunit;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Unit Test")
public class QaParameterizedTest extends ConfigJunit {


    // @Test
    @ParameterizedTest(name = "Parameter test with value {0}") // CZYSTSZY TEKST W RAPORCIE
    @ValueSource(ints= {5, 15, 25})
    public void firstParameterizedTest(int number) {

        assertTrue(number % 5 ==0);

        //int[] ints= {5, 15, 25};
        //for(int i=0; i <ints.length ; i++){
        //    assertTrue(ints[i] % 5 == 0);
        //}


    }

    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(strings= {"Hello", "Hello junit", "Hello students"})
    public void secondParameterizedTest(String text) {

        assertTrue(text.contains("Hello"));

    }

    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvSource(value = {"Hello, 5", "Hello junit 5, 15", "'Hello 5!', 25"}, delimiter = ',')
    public void nextParameterizedTest(String text, int number) {

        assertTrue(text.contains("Hello"));
        assertTrue(number % 5 ==0 );

    }

    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')
    public void csvFileParameterizedTest(String text, int number) {

        assertTrue(text.contains("Hello"));
        assertTrue(number % 5 ==0 );

    }

    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @EnumSource(value = ParamEnum.class)
    public void enumParameterizedTest(ParamEnum enumtype) {
        assertTrue(enumtype.toString().contains("ENUM"));

    }

    enum ParamEnum {
        ENUM_ONE,
        ENUM_TWO

    }

    @ParameterizedTest(name = "Test of Wordpress powers with value{0}")
    @ValueSource(strings = {"1", "10000", "100000000"})
    public void zadanie1(String text) {

        String resultString = "Wordpress powers " + text + "% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertTrue(resultString.startsWith("Wordpress powers"));
        assertTrue(resultString.endsWith("% of the internet"));
        assertThat(resultString).matches("(Wordpress powers )\\d+(% of the internet)");

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");
        int resultNumber = Integer.parseInt(result);
        assertTrue(resultNumber > 0 );
    }

    @ParameterizedTest(name = "Test of Wordpress powers with value{0}")
    @ValueSource(strings = {"1", "10000", "100000000"})
    public void zadanie1False(String text) {

        String resultString = "Wordpress powers " + text + "% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

//        assertTrue(resultString.startsWith("Wordpress powers"));
//        assertTrue(resultString.endsWith("% of the internet"));
//        assertThat(resultString).matches("(Wordpress powers )\\d+(% of the internet)");
        assertFalse(resultString.matches("\"(Wordpress powers )\\d+(% of the internet)"));

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");

//        int resultNumber = Integer.parseInt(result);
//        assertTrue(resultNumber > 0 );
    }

}
