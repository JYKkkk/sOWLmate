package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.type.RegionType;
import com.ssafy.sowlmate.entity.type.LanguageType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @GetMapping("interest")
    public ResponseEntity<?> getInterestTypes() {
        List<String> interestTypeList = new ArrayList<>();

        for (InterestType value : InterestType.values()) {
            interestTypeList.add(value.toString());
        }

        return ResponseEntity.ok().body(interestTypeList);
    }

    @GetMapping("obj/interest")
    public ResponseEntity<?> getInterestObjs() {
        Map<String, String> interestTypeList = new HashMap<>();

        for (InterestType value : InterestType.values()) {
            interestTypeList.put(value.toString(), value.getContent());
        }

        return ResponseEntity.ok().body(interestTypeList);
    }

    @GetMapping("region")
    public ResponseEntity<?> getRegions() {
        List<String> regionList = new ArrayList<>();

        for (RegionType regionType : RegionType.values()) {
            regionList.add(regionType.toString());
        }

        return ResponseEntity.ok().body(regionList);
    }

    @GetMapping("language")
    public ResponseEntity<?> getLanguages() {
        List<String> languageList = new ArrayList<>();

        for (LanguageType status : LanguageType.values()) {
            languageList.add(status.toString());
        }

        return ResponseEntity.ok().body(languageList);
    }
}
