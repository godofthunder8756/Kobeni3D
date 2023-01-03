package com.kobeni3D.engine.core;

import org.joml.Vector2d;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

public class MouseInput {
    private final Vector2d previousPos, currentPos;
    //private final Vector2f displVec;

    private boolean inWindow = false, leftbuttonPress = false, rightButtonPress = false;

    public MouseInput(){
        previousPos = new Vector2d(-1,-1);
        currentPos = new Vector2d(0,0);
        //displVec = new Vector2d();
    }
    public void init(){
        //GLFW.glfwSetCursorPosCallback(WindowManager.getWindow().getWin)
    }
}
