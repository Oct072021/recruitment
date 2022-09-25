package com.service;

import com.bean.CV;

import java.util.List;

public interface CVService {

    public int addCV(String CVPath, String CVName, int user_id, int com_id);

    public List<CV> findCVByCom_id(int com_id);

}
