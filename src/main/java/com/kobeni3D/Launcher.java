package com.kobeni3D;

import com.kobeni3D.core.EngineManager;
import com.kobeni3D.core.WindowManager;
import com.kobeni3D.core.utils.Consts;
import com.kobeni3D.test.TestGame;
import org.lwjgl.Version;

public class Launcher {
    private static WindowManager window;
    private static TestGame game;
    public static void main(String[] args){
        window = new WindowManager(Consts.TITLE, 1600, 900, false);
        game = new TestGame();
        EngineManager engine = new EngineManager();
        try{
            engine.start();
        }catch (Exception e){

        }
    }

    public static WindowManager getWindow() {
        return window;
    }

    public static TestGame getGame() {
        return game;
    }
}
