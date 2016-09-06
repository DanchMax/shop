package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Aging;
import ua.service.AgingService;

public class AgingEditor extends PropertyEditorSupport{
	
	
	private final AgingService agingService;
	
	public AgingEditor(AgingService agingService){
		this.agingService=agingService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Aging aging = agingService.findOne(Integer.valueOf(text));
		setValue(aging);
	}
}
