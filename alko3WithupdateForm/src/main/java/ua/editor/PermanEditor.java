package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Perman;
import ua.service.PermanService;

public class PermanEditor  extends PropertyEditorSupport{
	
	
	private final PermanService permanService;
	
	public PermanEditor(PermanService permanService){
		this.permanService=permanService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Perman perman = permanService.findOne(Integer.valueOf(text));
		setValue(perman);
	}

}
