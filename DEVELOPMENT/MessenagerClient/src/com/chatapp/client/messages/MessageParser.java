package com.chatapp.client.messages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chatapp.client.managers.ImageManager;

public class MessageParser {

	private final String REG_EX_SMILE_HAPPY = ":\\)";

	Pattern pattern;

	public String insertSmiles(String message) {
		pattern = Pattern.compile(REG_EX_SMILE_HAPPY);
		Matcher matcher = pattern.matcher(message);
		String prepMessage = matcher.replaceAll(ImageManager.IMG_SMILE_HAPPY);
		return prepMessage;
	}
}
