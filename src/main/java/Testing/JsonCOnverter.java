package Testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.UUID;

public class JsonCOnverter {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(JsonCOnverter.class.getClassLoader().getResource("json/set3.json"));

            if (root.isArray()) {
                ArrayNode outputArray = mapper.createArrayNode();

                for (JsonNode node : root) {
                    ObjectNode outputObject = mapper.createObjectNode();
                    
                    // Extracting specific fields
                    outputObject.put("question_key", node.path("question_key").asInt());
//                    outputObject.put("question_key", questionKey++);
                    outputObject.putArray("skills");
                    outputObject.putNull("toughness");
                    outputObject.put("short_text", "");
                    outputObject.put("question_type", "CODE_ANALYSIS_MULTIPLE_CHOICE");

                    ObjectNode explanationForAnswer = mapper.createObjectNode();
                    explanationForAnswer.put("content", node.path("explanation").asText());
                    explanationForAnswer.put("content_type", "MARKDOWN");
                    outputObject.set("explanation_for_answer", explanationForAnswer);

                    outputObject.put("question_text", node.path("question_text").asText());
                    outputObject.putArray("multimedia");
                    outputObject.put("content_type", "HTML");

                    ArrayNode tagNames = mapper.createArrayNode();
                    JsonNode tagNamesNode = node.path("tag_names");

                    if (!tagNamesNode.isMissingNode()) {
                        String tagNamesString = tagNamesNode.asText();
                        String[] tags = tagNamesString.split("\\n");

                        for (String tag : tags) {
                            tagNames.add(tag);
                        }
                        outputObject.set("tag_names", tagNames);
                    } else {
                        System.out.println("Tag names not found for a question.");
                    }

                    ArrayNode inputOutputArray = mapper.createArrayNode();
                    ObjectNode inputOutput = mapper.createObjectNode();
                    inputOutput.put("input", "");

                    String randomUUID = UUID.randomUUID().toString();
                    inputOutput.put("question_id", randomUUID);

                    String wOptions = node.path("w_options").asText();
                    String cOptions = node.path("c_options").asText();

                    ArrayNode wrongAnswers = mapper.createArrayNode();
                    String[] wrongOptions = wOptions.split("\\n");
                    for (String wrongOption : wrongOptions) {
                        wrongAnswers.add(wrongOption);
                    }
                    inputOutput.set("wrong_answers", wrongAnswers);

                    ArrayNode correctAnswers = mapper.createArrayNode();
                    correctAnswers.add(cOptions);
                    inputOutput.set("output", correctAnswers);

                    inputOutputArray.add(inputOutput);
                    outputObject.set("input_output", inputOutputArray);

                    ArrayNode codeMetadataArray = mapper.createArrayNode();
                    ObjectNode codeMetadata = mapper.createObjectNode();
                    codeMetadata.put("is_editable", false);
                    codeMetadata.put("language", "JAVA");
                    codeMetadata.put("code_data", node.path("code_data").asText());
                    codeMetadata.put("default_code", true);
                    codeMetadataArray.add(codeMetadata);

                    outputObject.set("code_metadata", codeMetadataArray);

                    outputArray.add(outputObject);
                }

                System.out.println(outputArray.toPrettyString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
