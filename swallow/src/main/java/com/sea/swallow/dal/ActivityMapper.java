package com.sea.swallow.dal;

import javax.inject.Named;

import com.sea.swallow.model.ActivityModel;

@Named("activityMapper")
public interface ActivityMapper {
	 int insertActivity(ActivityModel model);
}
