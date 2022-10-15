package builder;

import java.awt.*;

public class Font_Builder_Concrete implements Font_Builder_Interface{
	int fontSize;
	String selectFont;
	@Override
	public Font_Builder_Interface setFontSize(int fontSize) {
		// TODO Auto-generated method stub
		this.fontSize = fontSize;
		return this;		
	}

	@Override
	public Font_Builder_Interface setFont(String selectFont) {
		// TODO Auto-generated method stub
		this.selectFont = selectFont;
		return this;
	}

	@Override
	public Font create() {
		// TODO Auto-generated method stub
		return new Font(selectFont,Font.PLAIN,fontSize);
	}

}
