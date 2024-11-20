package ru.vsu.cs.kodintsev;

import java.util.ArrayList;
import java.util.List;

public class Model {
    protected List<float[]> vertices;
    protected List<int[]> faces;

    public Model() {
        this.vertices = new ArrayList<>();
        this.faces = new ArrayList<>();
    }

    public void addVertex(float x, float y, float z) {
        vertices.add(new float[]{x, y, z});
    }

    public void addFace(int[] face) {
        faces.add(face);
    }

    public List<float[]> getVertices() {
        return vertices;
    }

    public List<int[]> getFaces() {
        return faces;
    }
}
