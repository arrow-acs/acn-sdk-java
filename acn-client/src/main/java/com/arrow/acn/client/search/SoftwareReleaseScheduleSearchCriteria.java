package com.arrow.acn.client.search;

import java.time.Instant;
import java.util.Arrays;

import com.arrow.acn.client.model.DeviceCategory;
import com.arrow.acn.client.model.SoftwareReleaseScheduleStatus;
import com.arrow.acs.client.search.SearchCriteria;

public class SoftwareReleaseScheduleSearchCriteria extends SearchCriteria {

	private static final String FROM_SCHEDULED_DATE = "fromScheduledDate";
	private static final String TO_SCHEDULED_DATE = "toScheduledDate";
	private static final String SOFTWARE_RELEASE_HIDS = "softwareReleaseHids";
	private static final String CATEGORY = "category";
	private static final String OBJECT_HIDS = "objectHids";
	private static final String STATUSES = "statuses";
	private static final String NOTIFY_ON_START = "notifyOnStart";
	private static final String NOTIFY_ON_END = "notifyOnEnd";

	private PageSearchCriteria pageSearchCriteria = new PageSearchCriteria();

	public SoftwareReleaseScheduleSearchCriteria withFromScheduledDate(Instant fromScheduledDate) {
		simpleCriteria.put(FROM_SCHEDULED_DATE, fromScheduledDate.toString());
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withToScheduledDate(Instant toScheduledDate) {
		simpleCriteria.put(TO_SCHEDULED_DATE, toScheduledDate.toString());
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withSoftwareReleaseHids(String... softwareReleaseHids) {
		arrayCriteria.put(SOFTWARE_RELEASE_HIDS, softwareReleaseHids);
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withCategory(DeviceCategory category) {
		simpleCriteria.put(CATEGORY, category.toString());
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withObjectHids(String... objectHids) {
		arrayCriteria.put(OBJECT_HIDS, objectHids);
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withStatuses(SoftwareReleaseScheduleStatus... statuses) {
		if (statuses != null) {
			arrayCriteria.put(STATUSES, Arrays.stream(statuses).map(s -> s.toString()).toArray(String[]::new));
		}
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withNotifyOnStart(boolean notifyOnStart) {
		simpleCriteria.put(NOTIFY_ON_START, Boolean.valueOf(notifyOnStart).toString());
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withNotifyOnEnd(boolean notifyOnEnd) {
		simpleCriteria.put(NOTIFY_ON_END, Boolean.valueOf(notifyOnEnd).toString());
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withPage(long page) {
		pageSearchCriteria.withPage(page);
		simpleCriteria.putAll(pageSearchCriteria.getSimpleCriteria());
		return this;
	}

	public SoftwareReleaseScheduleSearchCriteria withSize(long size) {
		pageSearchCriteria.withSize(size);
		simpleCriteria.putAll(pageSearchCriteria.getSimpleCriteria());
		return this;
	}
}