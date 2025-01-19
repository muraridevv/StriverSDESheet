package com.murari.contest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class JsonPathParser {

    public static void main(String[] args) {
        String jsonPath1 = "$.regulator_cap_override[?(@.regulatory_cap_rate=='001' && @.industry_segment_code == '22')]";
        String jsonPath2 = "$.interchange_local_pricing.regulator_cap_override[?(@.regulatory_cap_rate=='001')]";
        String jsonPath3 = "$.speed_of_pay_data[?(@.transaction_class_code == 'A')].interchange_regional_pricing[?(@.pricing_region_identifier == '051')].regulatory_cap_override[?(@.regulatory_cap_rate == 'B')]";
        String jsonPath4 = "$";
        try {
            System.out.println("Example 1:");
            printJsonFromPath(jsonPath1);
        } catch (Exception e) {
            System.err.println("Error processing jsonPath1: " + e.getMessage());
        }

        try {
            System.out.println("\nExample 2:");
            printJsonFromPath(jsonPath2);
        } catch (Exception e) {
            System.err.println("Error processing jsonPath2: " + e.getMessage());
        }
    }

    private static void printJsonFromPath(String jsonPath)  {
        try {
            ObjectNode jsonObject = buildJsonFromJsonPath(jsonPath);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid JSON Path format: " + jsonPath, e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unexpected error while processing JSON Path: " + jsonPath, e);
        }
    }

    public static ObjectNode buildJsonFromJsonPath(String jsonPath) {
        try {
            String[] segments = parseJsonPath(jsonPath);

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode root = mapper.createObjectNode();
            ObjectNode currentNode = root;

            for (String segment : segments) {
                if (segment.contains("[?(")) {
                    // Handle array with filter
                    String key = segment.substring(0, segment.indexOf("["));
                    String filter = segment.substring(segment.indexOf("[?(@.") + 4, segment.indexOf(")]"));

                    String[] filterParts = filter.split("==");
                    String filterKey = filterParts[0].trim().replaceFirst("^\\.", ""); // Remove leading dot
                    String filterValue = filterParts[1].replace("'", "").trim();

                    // Add array node with filter condition
                    if (!currentNode.has(key)) {
                        currentNode.set(key, mapper.createArrayNode());
                    }
                    ArrayNode arrayNode = (ArrayNode) currentNode.get(key);

                    ObjectNode arrayItem = mapper.createObjectNode();
                    arrayItem.put(filterKey, filterValue);

                    arrayNode.add(arrayItem);
                    currentNode = arrayItem; // Continue nesting inside this item
                } else {
                    // Handle regular keys
                    if (!currentNode.has(segment)) {
                        currentNode.set(segment, mapper.createObjectNode());
                    }
                    currentNode = (ObjectNode) currentNode.get(segment);
                }
            }

            return root;
        } catch (Exception e) {
            throw new RuntimeException("Error building JSON from JSON Path: " + jsonPath, e);
        }
    }

    public static String[] parseJsonPath(String jsonPath) {
        try {
            // Remove root identifier '$.' and parse path into segments
            jsonPath = jsonPath.startsWith("$.") ? jsonPath.substring(2) : jsonPath;

            // Regex to match keys and array filters together (e.g., key[?(@.filter)])
            Pattern pattern = Pattern.compile("[^.\\[]+(\\[\\?\\(.*?\\)\\])?"); // Match keys with optional array filters
            Matcher matcher = pattern.matcher(jsonPath);

            List<String> segments = new ArrayList<>();
            while (matcher.find()) {
                segments.add(matcher.group());
            }

            return segments.toArray(new String[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON Path syntax: " + jsonPath, e);
        }
    }
}
