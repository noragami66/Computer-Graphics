package ru.vsu.cs.kodintsev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangulationTest {

    @Test
    public void testTriangulation() {
        Model model = new Model();
        model.addVertex(0, 0, 0);
        model.addVertex(1, 0, 0);
        model.addVertex(1, 1, 0);
        model.addVertex(0, 1, 0);
        model.addFace(new int[]{0, 1, 2, 3});

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);
        Assertions.assertEquals(2, triangulatedModel.getFaces().size());
    }

    @Test
    public void testEmptyModel() {
        Model model = new Model();
        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertTrue(triangulatedModel.getVertices().isEmpty());
        Assertions.assertTrue(triangulatedModel.getFaces().isEmpty());
    }

    @Test
    public void testSingleTriangle() {
        Model model = new Model();
        model.addVertex(0, 0, 0);
        model.addVertex(1, 0, 0);
        model.addVertex(0, 1, 0);
        model.addFace(new int[]{0, 1, 2});

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertEquals(1, triangulatedModel.getFaces().size());
        Assertions.assertArrayEquals(new int[]{0, 1, 2}, triangulatedModel.getFaces().get(0));
    }

    @Test
    public void testPentagon() {
        Model model = new Model();
        model.addVertex(0, 0, 0);
        model.addVertex(1, 0, 0);
        model.addVertex(1, 1, 0);
        model.addVertex(0.5f, 1.5f, 0);
        model.addVertex(0, 1, 0);
        model.addFace(new int[]{0, 1, 2, 3, 4});

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertEquals(3, triangulatedModel.getFaces().size());
    }

    @Test
    public void testVertexCoordinates() {
        Model model = new Model();
        model.addVertex(0, 0, 0);
        model.addVertex(1, 0, 0);
        model.addVertex(1, 1, 0);
        model.addVertex(0, 1, 0);
        model.addFace(new int[]{0, 1, 2, 3});

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertEquals(model.getVertices(), triangulatedModel.getVertices());
    }

    @Test
    public void testFaceIndices() {
        Model model = new Model();
        model.addVertex(0, 0, 0);
        model.addVertex(1, 0, 0);
        model.addVertex(1, 1, 0);
        model.addVertex(0, 1, 0);
        model.addFace(new int[]{0, 1, 2, 3});

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertArrayEquals(new int[]{0, 1, 2}, triangulatedModel.getFaces().get(0));
        Assertions.assertArrayEquals(new int[]{0, 2, 3}, triangulatedModel.getFaces().get(1));
    }
}
