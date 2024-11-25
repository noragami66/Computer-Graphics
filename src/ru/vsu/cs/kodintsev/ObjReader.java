package ru.vsu.cs.kodintsev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ObjReader {
    public static ModelOld read(String filePath) throws IOException {
        ModelOld model = new ModelOld();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("v ")) {
                String[] parts = line.split("\\s+");
                model.addVertex(
                        Float.parseFloat(parts[1]),
                        Float.parseFloat(parts[2]),
                        Float.parseFloat(parts[3])
                );
            } else if (line.startsWith("f ")) {
                String[] parts = line.split("\\s+");
                int[] face = new int[parts.length - 1];
                for (int i = 1; i < parts.length; i++) {
                    face[i - 1] = Integer.parseInt(parts[i].split("/")[0]) - 1;
                }
                model.addFace(face);
            }
        }
        reader.close();
        return model;
    }
}
