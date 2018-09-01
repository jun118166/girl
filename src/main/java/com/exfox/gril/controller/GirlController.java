package com.exfox.gril.controller;

import com.exfox.gril.domain.Girl;
import com.exfox.gril.domain.Result;
import com.exfox.gril.repository.GirlRepository;
import com.exfox.gril.service.GirlService;
import com.exfox.gril.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    private  static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> getList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girlAdd")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        Optional<Girl> optional = girlRepository.findById(id);
        if (optional != null) {
            return optional.get();
        }
        return null;
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("age") Integer age, @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setId(id);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
      girlService.getAge(id);
    }
}
