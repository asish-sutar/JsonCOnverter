# JSON Converter Utility
 
This Java utility, `JsonConverter`, facilitates the transformation of a JSON file into a customized JSON structure. It reads a given JSON file, extracts specific fields, and creates a new JSON structure based on predefined criteria.

## Overview

The `JsonConverter` is designed to perform the following operations:

- Reads an input JSON file (`set3.json`).
- Extracts specific fields from the input JSON.
- Constructs a new JSON structure with customized fields and configurations.
- Outputs the generated JSON to the console in a readable and structured format.

## Usage

1. **Input File:** Place the input JSON file `set3.json` in the designated location or configure the path within the code.

2. **Execute:** Run the `main()` method in `JsonConverter.java`.

3. **Output:** The utility generates a new JSON structure based on the provided criteria, displaying it in the console output.

## Input Json
{
    "question_type": "CODE_ANALYSIS_MULTIPLE_CHOICE",
    "question_text": "What is the output of the following code snippet in Java?",
    "question_key": 153,
    "content_type": "HTML",
    "multimedia_count": 0,
    "tag_names": "POOL_1\nTOPIC_GENERAL_CODING_ANALYSIS\nSOURCE_LETSFINDCOURSE\nDIFFICULTY_EASY\nIN_OFFLINE_EXAM",
    "c_options": 13,
    "w_options": "11\n12\n14",
    "options_content_type": "TEXT",
    "code_data": "int a = 5;\r\nint b = 7;\r\nint c = a++ + ++b;\r\nSystem.out.println(c);",
    "code_language": "JAVA",
    "explanation": "In this code, a is initalized to 5. variable b is initialized to 7. In c variable, a is post increamented and b is pre incremented. when a is post increamented the value of a is 5 but in memory it is 6. ++b means b is increamented to 8 so the value of a is 5 and b is 8 . So sum of a and b is 13.",
    "explanation_content_type": "MARKDOWN"
  }

## Output Json
[{
  "question_key" : 153,
  "skills" : [ ],
  "toughness" : null,
  "short_text" : "",
  "question_type" : "CODE_ANALYSIS_MULTIPLE_CHOICE",
  "explanation_for_answer" : {
    "content" : "In this code, a is initalized to 5. variable b is initialized to 7. In c variable, a is post increamented and b is pre incremented. when a is post increamented the value of a is 5 but in memory it is 6. ++b means b is increamented to 8 so the value of a is 5 and b is 8 . So sum of a and b is 13.",
    "content_type" : "MARKDOWN"
  },
  "question_text" : "What is the output of the following code snippet in Java?",
  "multimedia" : [ ],
  "content_type" : "HTML",
  "tag_names" : [ "POOL_1", "TOPIC_GENERAL_CODING_ANALYSIS", "SOURCE_LETSFINDCOURSE", "DIFFICULTY_EASY", "IN_OFFLINE_EXAM" ],
  "input_output" : [ {
    "input" : "",
    "question_id" : "18a2b028-a01f-429d-8d3d-d91cb672a608",
    "wrong_answers" : [ "11", "12", "14" ],
    "output" : [ "13" ]
  } ],
  "code_metadata" : [ {
    "is_editable" : false,
    "language" : "JAVA",
    "code_data" : "int a = 5;\r\nint b = 7;\r\nint c = a++ + ++b;\r\nSystem.out.println(c);",
    "default_code" : true
  } ]
}]


## Dependencies

- This utility uses the Jackson library for JSON processing.

## Code Structure

The code mainly consists of a single Java class, `JsonConverter`. It contains the `main()` method responsible for reading, processing, and generating the new JSON structure.

## Instructions

- Ensure the Jackson library is included in the classpath for successful execution.
- Customize the extraction and construction logic based on specific requirements by modifying the code within the `main()` method.
