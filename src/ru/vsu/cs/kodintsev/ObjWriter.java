package ru.vsu.cs.kodintsev;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class ObjWriter {
    public static void write(Model model, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (float[] vertex : model.getVertices()) {
                writer.write(String.format(Locale.US, "v %f %f %f\n", vertex[0], vertex[1], vertex[2]));
            }

            for (int[] face : model.getFaces()) {
                writer.write("f");
                for (int index : face) {
                    writer.write(" " + (index + 1));
                }
                writer.write("\n");
            }
        }
    }
}
