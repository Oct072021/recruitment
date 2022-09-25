package com.service.impl;

import com.bean.CV;
import com.dao.CVDao;
import com.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CVService")
@Transactional
public class CVServiceImpl implements CVService {

    @Autowired
    private CVDao cvDao;

    @Override
    public int addCV(String CVPath, String CVName,int user_id, int com_id) {
        return this.cvDao.addCV(CVPath, CVName,user_id, com_id);
    }

    @Override
    public List<CV> findCVByCom_id(int com_id) {
        return this.cvDao.findCVByCom_id(com_id);
    }
}
