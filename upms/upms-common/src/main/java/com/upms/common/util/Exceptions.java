package com.upms.common.util;

public class Exceptions {
	/**
	 * 将 CheckedException 转换为 UncheckedException
	 *
	 * @param e
	 *            CheckedException
	 * @return UncheckedException
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}
}
