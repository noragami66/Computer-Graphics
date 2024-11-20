package ru.vsu.cs.kodintsev;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class TriangulationApp {
    public static void main(String[] args) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Выберите модель для триангуляции");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int inputResult = fileChooser.showOpenDialog(null);
            if (inputResult != JFileChooser.APPROVE_OPTION) {
                System.out.println("Операция отменена.");
                return;
            }
            String inputPath = fileChooser.getSelectedFile().getAbsolutePath();

            Model model = ObjReader.read(inputPath);

            TriangulatedModel triangulatedModel = new TriangulatedModel(model);

            fileChooser.setDialogTitle("Сохраните триангулированную модель");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int outputResult = fileChooser.showSaveDialog(null);
            if (outputResult != JFileChooser.APPROVE_OPTION) {
                System.out.println("Операция отменена.");
                return;
            }

            String outputPath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!outputPath.endsWith(".obj")) {
                outputPath += ".obj";
            }

            ObjWriter.write(triangulatedModel, outputPath);

            System.out.println("Триангуляция завершена. Проверьте результат: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
