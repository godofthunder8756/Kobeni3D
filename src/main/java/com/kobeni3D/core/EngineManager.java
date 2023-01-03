package com.kobeni3D.core;

public class EngineManager {
    public static final long NANOSECOND = 1000000000L;
    public static final float FRAMERATE = 1000;

    private static int fps;
    private static float frametime = 1.0f / FRAMERATE;

    private boolean isRunning;

}
