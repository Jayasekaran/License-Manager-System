package com.service.user;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class LicenseApplication extends Application{
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> s = new HashSet<Class<?>>();
		return s;
	}
}