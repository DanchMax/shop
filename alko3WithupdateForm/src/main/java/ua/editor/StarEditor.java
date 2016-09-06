package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Star;
import ua.service.StarService;

public class StarEditor extends PropertyEditorSupport{
	
	
	private final StarService starService;
	
	public StarEditor(StarService starService){
		this.starService=starService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Star star = starService.findOne(Integer.valueOf(text));
		setValue(star);
	}

}
