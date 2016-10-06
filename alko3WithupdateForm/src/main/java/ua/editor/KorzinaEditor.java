package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Korzina;
import ua.service.KorzinaService;

public class KorzinaEditor extends PropertyEditorSupport{

	private final KorzinaService korzinaService;

	public KorzinaEditor(KorzinaService korzinaService) {
		this.korzinaService = korzinaService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Korzina korzina = korzinaService.findById(Integer.valueOf(text));
		setValue(korzina);
	}
}
