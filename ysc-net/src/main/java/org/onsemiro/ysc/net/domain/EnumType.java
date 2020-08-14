package org.onsemiro.ysc.net.domain;

import lombok.Getter;

public class EnumType {

	@Getter
	public enum FileType {
		JPG("image/jpeg"),
		PNG("image/png"),
		PDF("application/pdf");
		
		private String name;
		
		private FileType(String name) {
			this.name = name;
		}
	}
}
