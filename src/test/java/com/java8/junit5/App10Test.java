package com.java8.junit5;

import com.google.common.base.Strings;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import junit5.Parameter;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

@SuppressWarnings("InnerClassMayBeStatic")
class App10Test {

    @Nested
    @DisplayName("Given a name in greeting")
    class ParamemeterTest
    {

      private Parameter parameter;

        @BeforeEach
        void setUp () {
            parameter = new Parameter();
         }

       @Nested
       @DisplayName("When the Greeting")
       @TestInstance(Lifecycle.PER_CLASS)
        class greet {
          @ParameterizedTest(name="Greeting {0} gives \"{1}\"")
          @MethodSource(value = "greetings")
          void shouldReturnGreeting(String name, String expectedGreeting) {
                String greeting = parameter.greet(name);
                assertThat(greeting).isEqualTo(expectedGreeting);
          }

           private  Stream<Arguments> greetings() {
               return Stream.of(
                       Arguments.of("User", "Hello, User!"),
                       Arguments.of("World", "Hello, World!")
               );
           }

        }
        @Nested
        @DisplayName("When the Parameter as strings")
        class ParamString {
            @ParameterizedTest
            @ValueSource(strings = {
                    "",
                    " ", // Regular space, does not work for non-breaking spaces
                    "\t",
                    "\n",
                    "\r",
                    "\u005Ct", // Horizontal tabulation
                    "\u005Cn", // Line feed
                    "\u000B", // Vertical tabulator
                    "\u005Cf", // Form feed
                    "\u005Cr", // Carriage return
                    "\u001C", // File separator
                    "\u001D", // Group separator
                    "\u001E", // Record separator
                    "\u001F", // Unit separator
            })
            void shouldReturnemptyStrings_areBlank(String emptyString) {
                assertThat(StringUtils.isBlank(emptyString))
                        .isTrue();
            }

        }


    }
}
