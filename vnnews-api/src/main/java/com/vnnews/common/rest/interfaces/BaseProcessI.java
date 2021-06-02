package com.vnnews.common.rest.interfaces;

public interface BaseProcessI<REQ,REP>{
	REP processRequest(REQ request) ;
}
