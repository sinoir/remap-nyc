package com.mienaikoe.remap_nyc;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Jesse on 6/3/2015.
 */
public class RemapGLSurfaceView extends GLSurfaceView {

    private final RemapGLRenderer mRenderer;

    public RemapGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        mRenderer = new RemapGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
