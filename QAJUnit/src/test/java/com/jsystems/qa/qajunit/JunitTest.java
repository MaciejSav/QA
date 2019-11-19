package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Junit Test")
@Tag("unit")
public class JunitTest {


    @BeforeEach
    public void setupEach(TestInfo testInfo) {
        System.out.println("============BeforeEach==============");
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
    }

    @AfterEach
    public void tearDownEach() {
        System.out.println("============AfterEach==============");
    }

    final String stringTestowy = "stringTestowy";

    @Tag("first")
    @DisplayName("First junit test")
    @Test
//  @RepeatedTest(5)
    @Disabled("bug: import , 1230")

    public void firstTest() {
        assertTrue(stringTestowy.contains("tr"));
        assertTrue(5 == 2 + 3, "message for test result");
        assertFalse(stringTestowy.contains("z"));

        assertThat(stringTestowy).contains("r");
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        assertThat(stringTestowy).endsWith("wy");

    }


    @Test
    @Tag("second")
    public void secondTest() {
        System.out.println(0.2*02);
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        assertTrue(result ==0.04);
        assertFalse(0.2 * 0.2 == 0.04);
    }

    @Nested
    public class NestedTest {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5);


        @Test
        public void firstNestedTest() {
            assertTrue(list1.containsAll(list2));
            assertThat(list1).hasSize(5);
            assertThat(list1).containsAnyOf(1,2,3);
        }

        @Test
        public void secondNestedTest() {

        }
    }
}

