package tasks;

import static java.lang.System.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder(toBuilder = true)
public class BTreeUtils {


    public String serializeBTree(Object ob)  {
        JsonNode jsonNode = null;
        if (ob != null) {
            ObjectMapper mapper = new ObjectMapper();
            jsonNode = mapper.valueToTree(ob);
        }
        return (jsonNode != null) ? jsonNode.toString() : "";
    }

    public static void main(String[] args) {
        BTreeUtils build = new BTreeUtils().toBuilder().build();
        Map<String,String> src = new HashMap<>();
        src.put("key1", "value1");
        src.put("key2", "value2");
        String json = build.serializeBTree(src);
        out.println(json);
    }
}
