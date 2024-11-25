package ru.vsu.cs.kodintsev;

import ru.vsu.cs.kodintsev.model.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangulatedModel extends ModelOld {

    public TriangulatedModel(ModelOld model) {
        super();
        this.vertices = model.getVertices();
        triangulate(model.getFaces());
    }

    private void triangulate(List<int[]> faces) {
        for (int[] face : faces) {
            if (face.length <= 3) {
                addFace(face);
            } else {
                earClippingTriangulation(face);
            }
        }
    }

    boolean isClockwise(int[] face) {
        float sum = 0;
        for (int i = 0; i < face.length; i++) {
            float[] v1 = vertices.get(face[i]);
            float[] v2 = vertices.get(face[(i + 1) % face.length]);
            sum += (v2[0] - v1[0]) * (v2[1] + v1[1]);
        }
        return sum > 0;
    }

    private int[] ensureCounterClockwise(int[] face) {
        if (isClockwise(face)) {
            int[] reversed = new int[face.length];
            for (int i = 0; i < face.length; i++) {
                reversed[i] = face[face.length - i - 1];
            }
            return reversed;
        }
        return face;
    }

    private void earClippingTriangulation(int[] face) {
        face = ensureCounterClockwise(face);
        List<Integer> remainingVertices = new ArrayList<>();
        for (int v : face) {
            remainingVertices.add(v);
        }

        while (remainingVertices.size() > 3) {
            boolean earFound = false;

            for (int i = 0; i < remainingVertices.size(); i++) {
                int prev = remainingVertices.get((i - 1 + remainingVertices.size()) % remainingVertices.size());
                int curr = remainingVertices.get(i);
                int next = remainingVertices.get((i + 1) % remainingVertices.size());

                if (isEar(prev, curr, next, remainingVertices)) {
                    addFace(new int[]{prev, curr, next});
                    remainingVertices.remove(i);
                    earFound = true;
                    break;
                }
            }

            if (!earFound) {
                throw new RuntimeException("Не удалось провести триангуляцию для полигона: " + Arrays.toString(face));
            }
        }

        addFace(new int[]{
                remainingVertices.get(0),
                remainingVertices.get(1),
                remainingVertices.get(2)
        });
    }

    private boolean isEar(int prev, int curr, int next, List<Integer> remainingVertices) {
        if (!isConvex(prev, curr, next)) {
            return false;
        }

        for (int v : remainingVertices) {
            if (v != prev && v != curr && v != next && isPointInsideTriangle(v, prev, curr, next)) {
                return false;
            }
        }

        return true;
    }

    boolean isConvex(int prev, int curr, int next) {
        float[] v1 = vertices.get(curr);
        float[] v0 = vertices.get(prev);
        float[] v2 = vertices.get(next);

        float crossProduct = (v1[0] - v0[0]) * (v2[1] - v0[1]) - (v1[1] - v0[1]) * (v2[0] - v0[0]);

        return crossProduct > 0;
    }


    private boolean isPointInsideTriangle(int point, int a, int b, int c) {
        float[] p = vertices.get(point);
        float[] v0 = vertices.get(a);
        float[] v1 = vertices.get(b);
        float[] v2 = vertices.get(c);

        float denominator = (v1[1] - v2[1]) * (v0[0] - v2[0]) + (v2[0] - v1[0]) * (v0[1] - v2[1]);
        float alpha = ((v1[1] - v2[1]) * (p[0] - v2[0]) + (v2[0] - v1[0]) * (p[1] - v2[1])) / denominator;
        float beta = ((v2[1] - v0[1]) * (p[0] - v2[0]) + (v0[0] - v2[0]) * (p[1] - v2[1])) / denominator;
        float gamma = 1.0f - alpha - beta;

        return alpha >= 0 && beta >= 0 && gamma >= 0;
    }
}
