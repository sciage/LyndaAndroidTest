package pg.safexpay.live.lyndaandroidtest.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Recipe {
    private static final String ID_PREFIX = "id=";
    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Recipe readFromStream(InputStream stream){
        String id = null;
        String title = null;
        StringBuilder stringBuilder = new StringBuilder();
//        return null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine())
                if (line.startsWith(ID_PREFIX)){
                    id = line.substring(ID_PREFIX.length());
                    continue;
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Recipe(id, title, stringBuilder.toString());
    }
}
