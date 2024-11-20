package ru.vsu.cs.kodintsev;

import java.util.List;

public class TriangulatedModel extends Model {

    public TriangulatedModel(Model model) {
        super();
        this.vertices = model.getVertices();
        triangulate(model.getFaces());
    }

    private void triangulate(List<int[]> faces) {
        for (int[] face : faces) {
            if (face.length > 3) {
                for (int i = 1; i < face.length - 1; i++) {
                    addFace(new int[]{face[0], face[i], face[i + 1]});
                }
            } else {
                addFace(face);
            }
        }
    }
}
