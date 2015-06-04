package com.mienaikoe.remap_nyc.shapes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by Jesse on 6/4/2015.
 */
public class Square {

    private FloatBuffer vertexBuffer;
    private ShortBuffer drawListBuffer;

    // number of coordinates per vertex in this array
    static final int COORDS_PER_VERTEX = 3;
    static float squareCoords[] = {
            -0.5f,  0.5f, 0.0f,   // top left
            -0.5f, -0.5f, 0.0f,   // bottom left
            0.5f, -0.5f, 0.0f,   // bottom right
            0.5f,  0.5f, 0.0f }; // top right
            
    static float trainlineCoords[] = {
        198.f,1117.8f,0.f,
        230.5f,1379.5f,0.f,
        230.5f,1355.7f,0.f,
        190.f,1355.7f,0.f,
        198.f,1168.9f,0.f,
        159.8f,1168.9f,0.f,
        190.f,1237.2f,0.f,
        310.1f,1379.5f,0.f,
        320.2f,1389.6f,0.f,
        362.7f,1389.6f,0.f,
        385.3f,1412.2f,0.f,
        507.5f,1483.2f,0.f,
        436.6f,1412.2f,0.f,
        159.8f,1207.1f,0.f,
        214.1f,1101.7f,0.f,
        268.f,1101.7f,0.f,
        268.f,1036f,0.f,
        268.f,1101.7f,0.f,
        298.3f,1005.7f,0.f,
        268.f,1036f,0.f,
        252.8f,900.2f,0.f,
        252.8f,960.2f,0.f,
        268.f,1036f,0.f,
        252.8f,899.6f,0.f,
        252.8f,960.2f,0.f,
        298.3f,1005.7f,0.f
    }

    private short drawOrder[] = { 0, 1, 2, 0, 2, 3 }; // order to draw vertices

    public Square() {
        // initialize vertex byte buffer for shape coordinates
        ByteBuffer bb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 4 bytes per float)
                squareCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(squareCoords);
        vertexBuffer.position(0);

        // initialize byte buffer for the draw list
        ByteBuffer dlb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 2 bytes per short)
                drawOrder.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        drawListBuffer = dlb.asShortBuffer();
        drawListBuffer.put(drawOrder);
        drawListBuffer.position(0);
    }
}
