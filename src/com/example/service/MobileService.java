package com.example.service;

import java.util.Optional;

import com.example.model.DisplayFeatures;
import com.example.model.Mobile;
import com.example.model.ScreenResolution;

public class MobileService {

	public MobileService() {
	}

	public static void main(final String[] args) {

		final ScreenResolution screenResolution = new ScreenResolution(750, 440);

		// final ScreenResolution screenResolution = null;

		final DisplayFeatures displayFeatures = new DisplayFeatures("4.7", Optional.ofNullable(screenResolution));
		// final DisplayFeatures displayFeatures = null;

		final Mobile mobile = new Mobile(1234, "Apple", "Iphone", Optional.ofNullable(displayFeatures));

		System.out.println(getScreenWidth(Optional.of(mobile)));

	}

	/**
	 * flatMap could be useful if objects wrapped by Optional also contains Optional properties.
	 * @param mobileOptional
	 * @return
	 */
	private static int getScreenWidth(final Optional<Mobile> mobileOptional) {
		return mobileOptional.flatMap(Mobile::getDisplayFeatures).flatMap(DisplayFeatures::getResolution)
				.map(res -> res.getWidth()).orElse(0);

	}

}
