package com.exfox.gril.service;

import com.exfox.gril.enums.ResutlEnum;
import com.exfox.gril.exception.GirlException;
import com.exfox.gril.repository.GirlRepository;
import com.exfox.gril.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl = new Girl();
        girl.setAge(16);
        girl.setCupSize("A");
        girlRepository.save(girl);
        Girl girl1 = new Girl();
        girl1.setAge(18);
        girl1.setCupSize("B");
        girlRepository.save(girl1);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw  new GirlException(ResutlEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw  new GirlException(ResutlEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id){
        return  girlRepository.findById(id).get();
    }
}
