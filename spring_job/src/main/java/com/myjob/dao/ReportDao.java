package com.myjob.dao;

import com.myjob.data.ReportData;

public interface ReportDao {
	Integer exist(ReportData rpdata);
	void insert(ReportData rpdata);
}
