/*
 * S�bastien Leboucher
 */
    package com.example.project.parametrized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.EnumSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

class DisplayNameGeneratorDemoTest {

    @Nested
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = {-1, -4})
        void if_it_is_negative(int year) {
        }

        @Nested
        class A_year_is_a_leap_year {
            @Test
            void if_it_is_divisible_by_4_but_not_by_100() {
            }

            @ParameterizedTest(name = "Year {0} is a leap year.")
            @ValueSource(ints = { 2016, 2020, 2048 })
            void if_it_is_one_of_the_following_years(int year) {
            }
        }

        @ParameterizedTest
        //@NullSource
        //@EmptySource
        @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
        void palindromes(String candidate) {
            assertTrue(StringUtils.isNotBlank(candidate));
        }

        @ParameterizedTest
        @EnumSource(ChronoUnit.class)
        void testWithEnumSource(TemporalUnit unit) {
            assertNotNull(unit);
        }

        @ParameterizedTest
        @EnumSource(names = { "DAYS", "HOURS" })
        void testWithEnumSourceInclude(ChronoUnit unit) {
            assertTrue(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS).contains(unit));
        }
    }
}
