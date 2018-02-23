package com.orozco.did.experiments;

import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) throws Exception {
        // Open a valid json(-ld) input file
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("input.json");
        // Read the file into an Object (The type of this object will be a List, Map, String, Boolean,
        // Number or null depending on the root object in the file).
        Object jsonObject = JsonUtils.fromInputStream(inputStream);
        // Create a context JSON map containing prefixes and definitions
        Map context = new HashMap();
        // Customise context...
        // Create an instance of JsonLdOptions with the standard JSON-LD options
        JsonLdOptions options = new JsonLdOptions();
        // Customise options...
        // Call whichever JSONLD function you want! (e.g. compact)
        Object compact = JsonLdProcessor.compact(jsonObject, context, options);
        // Print out the result (or don't, it's your call!)
        System.out.println(JsonUtils.toPrettyString(compact));
    }
}
