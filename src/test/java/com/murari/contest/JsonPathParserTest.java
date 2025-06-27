package com.murari.contest;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

public class JsonPathParserTest {

  @Test
  void testValidJsonPath() {
    String jsonPath = "$.key[?(@.key=='value')].nested.key";
    assertDoesNotThrow(() -> JsonPathParser.buildJsonFromJsonPath(jsonPath));
  }

  @Test
  void testInvalidJsonPathSyntax() {
    String jsonPath = "$.key[?(@.missingOperator 'value')].key";
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> JsonPathParser.parseJsonPath(jsonPath));
    assertTrue(exception.getMessage().contains("Invalid JSON Path syntax"));
  }

  @Test
  void testMissingFilterInJsonPath() {
    String jsonPath = "$.key[?(@.filter)]";
    Exception exception =
        assertThrows(RuntimeException.class, () -> JsonPathParser.buildJsonFromJsonPath(jsonPath));
    assertTrue(exception.getMessage().contains("Error building JSON from JSON Path"));
  }

  @Test
  void testInvalidFilterFormat() {
    String jsonPath = "$.key[?(@.filterKey=1)].key";
    Exception exception =
        assertThrows(RuntimeException.class, () -> JsonPathParser.buildJsonFromJsonPath(jsonPath));
    assertTrue(exception.getMessage().contains("Error building JSON from JSON Path"));
  }

  @Test
  void testEmptyJsonPath() {
    String jsonPath = "";
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> JsonPathParser.parseJsonPath(jsonPath));
    assertTrue(exception.getMessage().contains("Invalid JSON Path syntax"));
  }

  @Test
  void testNullJsonPath() {
    String jsonPath = null;
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> JsonPathParser.parseJsonPath(jsonPath));
    assertTrue(exception.getMessage().contains("Invalid JSON Path syntax"));
  }

  @Test
  void testValidJsonPathWithoutArrays() {
    String jsonPath = "$.simple.key";
    ObjectNode result = JsonPathParser.buildJsonFromJsonPath(jsonPath);
    assertNotNull(result);
    assertTrue(result.has("simple"));
    assertTrue(result.get("simple").has("key"));
  }

  @Test
  void testJsonPathWithNestedArrays() {
    String jsonPath = "$.key1[?(@.key2=='value')].key3[?(@.key4=='value4')].key5";
    ObjectNode result = JsonPathParser.buildJsonFromJsonPath(jsonPath);
    assertNotNull(result);
  }

  @Test
  void testUnexpectedError() {
    String jsonPath = "$.key[?(@.unexpected)]";
    Exception exception =
        assertThrows(RuntimeException.class, () -> JsonPathParser.buildJsonFromJsonPath(jsonPath));
    assertTrue(exception.getMessage().contains("Error building JSON from JSON Path"));
  }
}
