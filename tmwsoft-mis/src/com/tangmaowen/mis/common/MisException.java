package com.tangmaowen.mis.common;

/**
 * @author 唐懋文
 * @since 2009-10-25 下午02:05:29
 * 
 */
public class MisException extends RuntimeException {
	public MisException(String message) {
		super(message);
	}

	public MisException(Throwable t) {
		this(t.toString(), t);
	}

	public MisException(String message, Throwable t) {
		super(message, t);
		this.setStackTrace(t.getStackTrace());
	}
}
