package com.mygdx.nextSectionChecker;

import com.mygdx.model.event.EventParameters;

public class MoveFieldChecker implements NextSectionChecker {

	@Override
	public boolean checkNextEvent(EventParameters eventParameter, String... args) {
		if (args.length > 0) {
			String arrowPath = eventParameter.getLocation().getArrowLabel();
			return ArgumentChecker.checkIsSame(arrowPath, args[0]);
		} else {
			return false;
		}
	}
}
