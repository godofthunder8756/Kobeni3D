package com.kobeni3D.engine.game;

import com.kobeni3D.engine.core.*;
import com.kobeni3D.engine.core.*;
import com.kobeni3D.engine.core.entity.Entity;
import com.kobeni3D.engine.core.entity.Model;
import com.kobeni3D.engine.core.entity.Texture;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class TestGame implements ILogic {

    private static final float CAMERA_MOVE_SPEED = 0.05f;
    private static final float MOUSE_SENSITIVITY = 0.02f;
    private final RenderManager renderer;
    private final ObjectLoader loader;
    private final WindowManager window;

    private Entity entity;
    private Camera camera;

    Vector3f cameraInc;

    public TestGame() {
        renderer = new RenderManager();
        window = Main.getWindow();
        loader = new ObjectLoader();
        camera = new Camera();
        cameraInc = new Vector3f(0,0,0);
    }
    @Override
    public void init() throws Exception {
        renderer.init();



        Model model = loader.loadOBJModel("/models/bunny.obj");
        model.setTexture(new Texture(loader.loadTexture("textures/grassblock.png")), 1f);
        entity = new Entity(model, new Vector3f(0,0,-5), new Vector3f(0,0,0), 1);
    }

    @Override
    public void input() {
        cameraInc.set(0,0,0);
        if(window.isKeyPressed(GLFW.GLFW_KEY_W))
            cameraInc.z =-1;
        if(window.isKeyPressed(GLFW.GLFW_KEY_S))
            cameraInc.z =1;
        if(window.isKeyPressed(GLFW.GLFW_KEY_A))
            cameraInc.x =-1;
        if(window.isKeyPressed(GLFW.GLFW_KEY_D))
            cameraInc.x =1;
        if(window.isKeyPressed(GLFW.GLFW_KEY_Z))
            cameraInc.y =-1;
        if(window.isKeyPressed(GLFW.GLFW_KEY_X))
            cameraInc.y =1;
    }

    @Override
    public void update(float interval, MouseInput mouseInput) {
        camera.movePosition(cameraInc.x * CAMERA_MOVE_SPEED, cameraInc.y * CAMERA_MOVE_SPEED, cameraInc.z * CAMERA_MOVE_SPEED);
        if(mouseInput.isRightButtonPress()){
            Vector2f rotVec = mouseInput.getDisplVec();
            camera.movePosition(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
        }
        entity.incRotation(0.0f,0.25f, 0.0f);
    }

    @Override
    public void render() {
//        if(window.isResize()){
//            GL11.glViewport(0,0,window.getWidth(),window.getHeight());
//            window.setResize(true);
//        }
        renderer.render(entity, camera);
    }

    @Override
    public void cleanup() {
        renderer.cleanup();
        loader.cleanup();
    }
}
