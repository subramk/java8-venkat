package com.java8.junit5;

@SuppressWarnings("InnerClassMayBeStatic")
class App10Test {

//    @Nested
//    @DisplayName("Given a name in greeting")
//    class ParamemeterTest
//    {
//
//      private Parameter parameter;
//
//        @BeforeEach
//        void setUp () {
//            parameter = new Parameter();
//         }
//
//       @Nested
//       @DisplayName("When the Greeting")
//       @TestInstance(Lifecycle.PER_CLASS)
//        class greet {
//          @ParameterizedTest(name="Greeting {0} gives \"{1}\"")
//          @MethodSource(value = "greetings")
//          void shouldReturnGreeting(String name, String expectedGreeting) {
//                String greeting = parameter.greet(name);
//                assertThat(greeting).isEqualTo(expectedGreeting);
//          }
//
//           private  Stream<Arguments> greetings() {
//               return Stream.of(
//                       Arguments.of("User", "Hello, User!"),
//                       Arguments.of("World", "Hello, World!")
//               );
//           }
//
//        }
//        @Nested
//        @DisplayName("When the Parameter as strings")
//        class ParamString {
//            @ParameterizedTest
//            @ValueSource(strings = {
//                    "",
//                    " ", // Regular space, does not work for non-breaking spaces
//                    "\t",
//                    "\n",
//                    "\r",
//                    "\u005Ct", // Horizontal tabulation
//                    "\u005Cn", // Line feed
//                    "\u000B", // Vertical tabulator
//                    "\u005Cf", // Form feed
//                    "\u005Cr", // Carriage return
//                    "\u001C", // File separator
//                    "\u001D", // Group separator
//                    "\u001E", // Record separator
//                    "\u001F", // Unit separator
//            })
//            void shouldReturnemptyStrings_areBlank(String emptyString) {
//                assertThat(StringUtils.isBlank(emptyString))
//                        .isTrue();
//            }
//
//        }
//
//
//    }
}
