import static org.lwjgl.glfw.GLFW.glfwGetCursorPos;

import java.nio.DoubleBuffer;

import org.lwjgl.BufferUtils;

public class Button {

	private float[] button;
	private int click;
	float x, x2,y2,y, x_C, y_C;
	public float[] button (float x, float x2, float y, float y2)
	{
		float X = x/300-1;
		float X2 = x2/300-1;
		float Y = -y/300+1;
		float Y2 = -y2/300+1;
		
		this.x =x;
		this.x2=x2;
		this.y=y;
		this.y2=y2;
		float[] button = new float[]
				{
						 X,  Y,0,
						 X2,  Y,0,
						 X2,  Y2,0,
						
						 X2,  Y2,0,
						 X,  Y2 ,0,
						 X, Y,0,
						
				};
		
		return button;
	}
	public float getx() {
		return x;
	}
	
	public float getx2()
	{
		return x2;
	}
	
	public float gety2() {
		return y2;
	}
	
	public float gety() {
		return y;
	}
	
	public float getx_C()
	{
		x_C=(x-x2)/2;
		return x_C;
	}
	
	public float gety_C()
	{
		y_C=(y-y2)/2;
		return y_C;
	}
	public int mClick (double x, double y, Button b )
	{
		if(x>= b.getx() && x<=b.getx2())
		{
			if(y>=100 &&y<=500)
			{
				click=(int) (y/100);
			}
			
		
//		if(x >= 150 && x <= 450)
//		{
//			if( y >= 75 && y <= 225)
//		{
//			System.out.println("Test");
//			 click = 1;
//		}
//		if( y >= 225 && y <= 375)
//		{
//			System.out.println("In");
//			 click = 2;
//		}
//		if(y >= 225 && y<= 525 )
//		{
//		 click = 3;
//		}
		
	}
	
		return click ;
}
	public int gClick ( double x, double y,Button b, Button b2)
	{
		
		if ( y >= b.gety() && y<=b.gety2() )
		{
			if(x >= 0 && x<= 50)
			{
				click = 1;
			}
			
			if( x>= 50 && x<=75)
			{
				click = 2;
			}
			
			if ( x>=80 && x<=130)
			{
				System.out.println("TESTING");
				click=3;
			}
		}
//		if(x>= b2.getx() && x<= b2.getx2())
//		{
//			
//		}
		return click;
	}
}
