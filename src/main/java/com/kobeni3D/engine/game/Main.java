package com.kobeni3D.engine.game;

import com.kobeni3D.engine.core.EngineManager;
import com.kobeni3D.engine.core.WindowManager;
import com.kobeni3D.engine.utils.Consts;

public class Main {
    private static WindowManager window;
    private static TestGame game;
    public static void main(String[] args){
//        window = new WindowManager(Consts.TITLE, 1600, 900, false);
        window = new WindowManager(Consts.TITLE, 0, 0, false);
        game = new TestGame();
        EngineManager engine = new EngineManager();
        try{
            engine.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static WindowManager getWindow() {
        return window;
    }

    public static TestGame getGame() {
        return game;
    }
}
