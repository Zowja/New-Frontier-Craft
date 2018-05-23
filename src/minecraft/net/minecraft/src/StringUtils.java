package net.minecraft.src;

import java.util.regex.Pattern;

public class StringUtils {
	private static final Pattern patternControlCode = Pattern
			.compile("(?i)\\u00A7[0-9A-FK-OR]");
	private static final String __OBFID = "CL_00001501";

	/**
	 * Returns the time elapsed for the given number of ticks, in "mm:ss"
	 * format.
	 */
	public static String ticksToElapsedTime(int par0) {
		int var1 = par0 / 20;
		int var2 = var1 / 60;
		var1 %= 60;
		return var1 < 10 ? var2 + ":0" + var1 : var2 + ":" + var1;
	}

	public static String stripControlCodes(String par0Str) {
		return patternControlCode.matcher(par0Str).replaceAll("");

	}

	/**
	 * Returns a value indicating whether the given string is null or empty.
	 */
	public static boolean isNullOrEmpty(String p_151246_0_) {
		return p_151246_0_ == null || "".equals(p_151246_0_);
	}
}