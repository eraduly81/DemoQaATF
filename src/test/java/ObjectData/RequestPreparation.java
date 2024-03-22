package ObjectData;

import java.util.HashMap;

public interface RequestPreparation {

    //this interface will serialise a specific request body
    void prepareObject(HashMap<String, String> testData);
}
