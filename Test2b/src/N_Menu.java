import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;


import java.nio.*;



import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class N_Menu {


	// The window handle
	private long window;
	private Model model, model2, model3, model4;
	//private Button game;
	private float[]  vertices2;
	private int width =600, height=600, w = 300, h= 300;
	
	public void run() {

		init();
		loop();

		// Free the window callbacks and destroy the window
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);

		// Terminate GLFW and free the error callback
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
//static void CursorPositionCallback (glfwWindow *window, double xpos, double ypos);
	private void init() {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");

		// Configure GLFW
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

		// Create the window
		window = glfwCreateWindow(width, height, "Menu", NULL, NULL);
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");

		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
		});

		// Get the thread stack and push a new frame
		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1); // int*
			IntBuffer pHeight = stack.mallocInt(1); // int*

			// Get the window size passed to glfwCreateWindow
			glfwGetWindowSize(window, pWidth, pHeight);

			// Get the resolution of the primary monitor
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			// Center the window
			glfwSetWindowPos(
				window,
				(vidmode.width() - pWidth.get(0)) / 2,
				(vidmode.height() - pHeight.get(0)) / 2
			);
		} // the stack frame is popped automatically

		// Make the OpenGL context current
		
		// Enable v-sync
	
		
	
		
		
		
		
		// Make the window visible
		glfwShowWindow(window);
	}

	
	
	
	
	private void loop() {
		// This line is critical for LWJGL's interoperation with GLFW's
		// OpenGL context, or any context that is managed externally.
		// LWJGL detects the context that is current in the current thread,
		// creates the GLCapabilities instance and makes the OpenGL
		// bindings available for use.
		glfwMakeContextCurrent(window);
		
		GL.createCapabilities();
		Button button = new Button();
		
		
		
		float[] texture = new float[]
				{
						0,0,
						1,0,
						1,1,
						
						1,1,
						0,1,
						0,0
				};
		
		
		
		model = new Model(button.button(150, 450, 100, 200), texture);
		
		 model2 = new Model(button.button(150, 450, 200, 300), texture);
		 
		 model3 = new Model(button.button(150, 450, 300, 400), texture);
		 
		 model4 = new Model(button.button(150, 450, 400, 500), texture);
		
		glEnable(GL_TEXTURE_2D);
		
		
		// Set the clear color
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		Texture tex = new Texture ("./Img/GameB.png");
		Texture tex2 = new Texture ("./Img/GB.png");
		Texture tex3 = new Texture ("./Img/CustomB.png");
		Texture tex4 = new Texture ("./img/InfoB.png");
		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		
		
		while ( !glfwWindowShouldClose(window) ) {
			glClear(GL_COLOR_BUFFER_BIT); // clear the framebuffer

			if(glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_1) == GL_TRUE)
			{
				DoubleBuffer b1 = BufferUtils.createDoubleBuffer(1);
				DoubleBuffer b2 = BufferUtils.createDoubleBuffer(1);
				glfwGetCursorPos(window, b1, b2);
				System.out.println("x : " + b1.get(0) + ", y = " + b2.get(0));
			
				int b = button.mClick(b1.get(0), b2.get(0),button);
				if (b>0)
				{
					
				switch (b)
				{
				case 1: 
					glfwDestroyWindow(window);new Game().run();
				break;
				
				case 2: glfwDestroyWindow(window);new Lesson().run();
				break;
				case 3: glfwDestroyWindow(window);new Customized().run();
				break;
				case 4: new Instructions().userGuide_mode();
				break;
				}
				
				}
				
			
			
			}
			
			glfwPollEvents();
			 // swap the color buffers

			
			tex.bind();
			model.render();
			
			
			tex2.bind();
			model2.render();
			
			tex3.bind();
			model3.render();
		
			tex4.bind();
			model4.render();
			
			// Poll for window events. The key callback above will only be
			// invoked during this call.
			glfwSwapBuffers(window);
		}
	}

	public static void main(String[] args) {
		new N_Menu().run();
	}



}
