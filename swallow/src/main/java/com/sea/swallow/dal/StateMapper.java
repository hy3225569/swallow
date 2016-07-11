package com.sea.swallow.dal;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.sea.swallow.model.StateModel;

@Named("stateMapper")
public interface StateMapper {
	List<StateModel>  selectStateList(Map<String,Object> map);
	
	int insertState(StateModel state);
}
