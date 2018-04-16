import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.*;
import java.io.*;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Customized {
private int transU = 0, transD=0;
	// The window handle
	private long window;
	private Button shape;
private Model model;
private Model model2, model3, model4, model5, lev,lev1, lev2,lev4,lev3,model11 ;
private double dx = 0 ,dy = 0;
GLFWScrollCallbackI scrollCallback = null;
//void scrollCallback(GLFWwindow* window, double xoffset, double yoffset );
	public void run() {
		System.out.println("Hello LWJGL " + Version.getVersion() + "!");

		init();
		loop();

		// Free the window callbacks and destroy the window
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);

		// Terminate GLFW and free the error callback
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

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
		window = glfwCreateWindow(600, 600, "Customized Mode", NULL, NULL);
		
		glfwSetScrollCallback(window, scrollCallback );
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
		Button button2 = new Button();

		
		float[] texture = new float[]
				{
						0,0,
						1,0,
						1,1,
						
						1,1,
						0,1,
						0,0
				};
		
		
		
		model = new Model(button.button(0, 50, 0, 25), texture);
		
		 model2 = new Model(button.button(50, 75, 0, 25), texture);
		 
		 model3 = new Model(button.button(80, 130, 0, 25), texture);
		 
		 model4 = new Model(button.button(130, 180, 0, 25), texture);
		 
		 model5 = new Model(button.button(180, 230, 0, 25), texture);
		
		 lev = new Model(button2.button(0, 75, 25, 55), texture);
		 
		 lev1 = new Model(button2.button(0, 75, 55, 130), texture);
		 
		 lev2 = new Model(button2.button(0, 75,  130,205), texture);
		 
		 lev3 = new Model(button2.button(0, 75, 205,280), texture);
		 
		 lev4 = new Model(button2.button(0, 75, 280, 355), texture);
		 
//		 model11 = new Model(button.button(100, 200, 200, 100), texture);
		 
		glEnable(GL_TEXTURE_2D);
		
		Texture tex = new Texture ("./Img/MenuB.png");
		
		Texture tex2 = new Texture ("./Img/InfoB.png");
		
		Texture tex3 = new Texture("./Img/Rect.png");
		
		Texture tex4 = new Texture("./Img/Circ.png");
		
		Texture tex5 = new Texture("./Img/Ramp.png");
		
		Texture tex6 = new  Texture("./Img/Lev.png");
		
		Texture tex7 = new Texture("./Img/Lev1.png");

		Texture tex8 = new Texture("./Img/Lev2.png");
		
		Texture tex9 = new Texture("./Img/Lev3.png");
		
		Texture tex10 = new Texture("./Img/Lev4.png");

		
		//Texture tex3 = new
		// Set the clear color
		glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		
		int tr = 0;
		while ( !glfwWindowShouldClose(window) ) {
			
			glClear(GL_COLOR_BUFFER_BIT); // clear the framebuffer
			
			
			
			
			glfwPollEvents();
			 // swap the color buffers

		
			
			while(glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_1) == GLFW_PRESS && tr==1)
			{
				
				DoubleBuffer b1 = BufferUtils.createDoubleBuffer(1);
				DoubleBuffer b2 = BufferUtils.createDoubleBuffer(1);
				glfwGetCursorPos(window, b1, b2);
				System.out.println("x : " + b1.get(0) + ", y = " + b2.get(0));
			
				
				Translate translate= new Translate();

				Model model12= new Model(translate.drag((float)(b1.get(0)),(float)( b2.get(0)), shape), texture);
						
				tex3.bind();
				model12.render();	
			}
			
			if(glfwGetKey(window, GLFW_KEY_UP) == GL_TRUE)
			{
				transU-=1;
				lev1 = new Model(button2.button(0, 75, 55+transU, 130+transU), texture);
				 lev2 = new Model(button2.button(0, 75,  130+transU,205+transU), texture);
				 
				 lev3 = new Model(button2.button(0, 75, 205+transU,280+transU), texture);
				 
				 lev4 = new Model(button2.button(0, 75, 280+transU, 355+transU), texture);
				
				
			}
			
			if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
			{
				transU+=1;
				lev1 = new Model(button2.button(0, 75, 55+transU, 130+transU), texture);
				 lev2 = new Model(button2.button(0, 75,  130+transU,205+transU), texture);
				 
				 lev3 = new Model(button2.button(0, 75, 205+transU,280+transU), texture);
				 
				 lev4 = new Model(button2.button(0, 75, 280+transU, 355+transU), texture);
				
				
			}
			if(glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_1) == GL_TRUE)
			{
				DoubleBuffer b1 = BufferUtils.createDoubleBuffer(1);
				DoubleBuffer b2 = BufferUtils.createDoubleBuffer(1);
				glfwGetCursorPos(window, b1, b2);
				System.out.println("x : " + b1.get(0) + ", y = " + b2.get(0));
			
				
				int b = button.gClick(b1.get(0), b2.get(0), button, button2);
				if (b>0)
				{
					
				switch (b)
				{
				case 1: 
					
				glfwDestroyWindow(window);new N_Menu().run();
				break;
				
				case 2:
					
					
				new Instructions().userGuide_mode();
				break;
				case 3: 
					//System.out.println("TEsting");
					
				
					tr=1;
					
				break;
				
				}
				
				}
				System.out.println("b = "+b);
			}

			if( tr ==1)
			{
				Button shape = new Button();
				
				model11 = new Model(shape.button(100, 200, 200, 100), texture);
				tex3.bind();
				model11.render();
			}
			
			tex2.bind();
			model2.render();
			
			tex.bind();
			model.render();
			
			tex3.bind();
			model3.render();
			
			tex4.bind();
			model4.render();
			
			tex5.bind();
			model5.render();
			
			tex6.bind();
			lev.render();
			
			tex7.bind();
			lev1.render();
		
			tex8.bind();
			lev2.render();
			
			tex9.bind();
			lev3.render();
			
			tex10.bind();
			lev4.render();
			//glfwSwapBuffers(window);
			
			
			
			// Poll for window events. The key callback above will only be
			// invoked during this call.
			 glfwSwapBuffers(window);
			
		}
	
	}
	

	void scrollCallback(long window, double xoffset, double yoffset)
	{
	  if (yoffset>0)
	  {
		  System.out.println("Scrolled" + yoffset);
	  }
	  if(xoffset>0)
	  {
		  System.out.println("Scrolled" + xoffset);
	  }
	}
	public static void main(String[] args) {
		new Customized().run();
	}

	

}