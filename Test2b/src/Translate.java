
public class Translate {
private float x_t, y_t;
private float[] New;
	public float[] drag(float x_C, float y_C, Button b )
	{
		Button button = new Button();
		x_t=x_C- b.getx_C();
		y_t = y_C-b.gety_C();
		
		New = button.button(b.getx() + x_t, b.getx2() + x_t, b.gety() + y_t, b.gety2() + y_t);
		
		return New;
	}
}
