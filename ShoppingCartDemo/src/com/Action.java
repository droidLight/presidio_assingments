package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
