package ru.vsu.cs.kodintsev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangulationTest {

    @Test
    public void testTriangulation() {
        ModelOld model = new ModelOld();
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
        ModelOld model = new ModelOld();
        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertTrue(triangulatedModel.getVertices().isEmpty());
        Assertions.assertTrue(triangulatedModel.getFaces().isEmpty());
    }

    @Test
    public void testSingleTriangle() {
        ModelOld model = new ModelOld();
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
        ModelOld model = new ModelOld();
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
        ModelOld model = new ModelOld();
        model.addVertex(0, 0, 0);
        model.addVertex(1, 0, 0);
        model.addVertex(1, 1, 0);
        model.addVertex(0, 1, 0);
        model.addFace(new int[]{0, 1, 2, 3});

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertEquals(model.getVertices(), triangulatedModel.getVertices());
    }

    @Test
    public void testNonConvexPolygon() {
        ModelOld model = new ModelOld();
        model.addVertex(0.0f, 0.0f, 0.0f); // 0
        model.addVertex(0.0f, 1.0f, 0.0f); // 1
        model.addVertex(1.0f, 1.0f, 0.0f); // 2
        model.addVertex(1.0f, 0.0f, 0.0f); // 3
        model.addVertex(0.8f, 0.0f, 0.0f); // 4
        model.addVertex(0.8f, 0.6f, 0.0f); // 5
        model.addVertex(0.2f, 0.6f, 0.0f); // 6
        model.addVertex(0.2f, 0.0f, 0.0f); // 7

        model.addFace(new int[]{0, 7, 6});
        model.addFace(new int[]{5, 4, 3});
        model.addFace(new int[]{5, 3, 2});
        model.addFace(new int[]{6, 5, 2});
        model.addFace(new int[]{6, 2, 1});
        model.addFace(new int[]{6, 1, 0});

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertEquals(6, triangulatedModel.getFaces().size());

        Assertions.assertArrayEquals(new int[]{0, 7, 6}, triangulatedModel.getFaces().get(0));
        Assertions.assertArrayEquals(new int[]{5, 4, 3}, triangulatedModel.getFaces().get(1));
        Assertions.assertArrayEquals(new int[]{5, 3, 2}, triangulatedModel.getFaces().get(2));
        Assertions.assertArrayEquals(new int[]{6, 5, 2}, triangulatedModel.getFaces().get(3));
        Assertions.assertArrayEquals(new int[]{6, 2, 1}, triangulatedModel.getFaces().get(4));
        Assertions.assertArrayEquals(new int[]{6, 1, 0}, triangulatedModel.getFaces().get(5));
    }

    @Test
    public void testConvexTriangle() {
        ModelOld model = new ModelOld();
        model.addVertex(0, 0, 0);
        model.addVertex(1, 0, 0);
        model.addVertex(0, 1, 0);

        TriangulatedModel triangulatedModel = new TriangulatedModel(model);

        Assertions.assertTrue(triangulatedModel.isConvex(0, 1, 2));
    }
}
