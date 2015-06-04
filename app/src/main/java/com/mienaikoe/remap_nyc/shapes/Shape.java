package com.mienaikoe.remap_nyc.shapes;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by Jesse on 6/4/2015.
 */
public abstract class Shape {

    protected final int mProgram;

    protected static final int COORDS_PER_VERTEX = 3;
    protected static final int VERTEX_STRIDE = COORDS_PER_VERTEX * 4; // 4 bytes per vertex



    protected FloatBuffer vertexBuffer;


    protected Shape(){
        // create empty OpenGL ES Program
        mProgram = GLES20.glCreateProgram();
    }


    protected void setCoordinates( float[] triangleCoords ){
        // initialize vertex byte buffer for shape coordinates
        ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length * 4);
        // (number of coordinate values * 4 bytes per float)

        // use the device hardware's native byte order
        bb.order(ByteOrder.nativeOrder());

        // create a floating point buffer from the ByteBuffer
        vertexBuffer = bb.asFloatBuffer();
        // add the coordinates to the FloatBuffer
        vertexBuffer.put(triangleCoords);
        // set the buffer to read the first coordinate
        vertexBuffer.position(0);
    }

    protected void initializeGL( String vertexShaderCode, String fragmentShaderCode ){
        // add the vertex shader to program
        int vertexShader = ShaderUtil.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        GLES20.glAttachShader(mProgram, vertexShader);

        // add the fragment shader to program
        int fragmentShader = ShaderUtil.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        GLES20.glAttachShader(mProgram, fragmentShader);

        // creates OpenGL ES program executables
        GLES20.glLinkProgram(mProgram);
    }

    protected void initializeDraw(){

    }
}
