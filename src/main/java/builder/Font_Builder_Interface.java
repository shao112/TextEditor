package builder;

import java.awt.*;

public interface Font_Builder_Interface {
	public Font_Builder_Interface setFontSize(int fontSize);
	public Font_Builder_Interface setFont(String selectFont);
	public Font create();	//�^�ǳгy�@��Font
}
