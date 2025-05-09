package com.n7ws.back.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.mapper.HealthInfoMapper;
import com.n7ws.back.model.HealthInfoModel;
import com.n7ws.back.repository.HealthInfoRepository;


@RestController
@RequestMapping("/healthInfos")
public class HealthInfoController {

    @Autowired
    HealthInfoRepository repository;

	@GetMapping
	public Collection<HealthInfoModel> healthInfos() {
		return repository.findAll().stream()
			.map(healthInfo -> HealthInfoMapper.toDomain(healthInfo))
			.map(healthInfo -> HealthInfoMapper.toModel(healthInfo))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public HealthInfoModel healthInfo(@PathVariable String uid) {
		return repository.findAll().stream()
			.map(healthInfo -> HealthInfoMapper.toDomain(healthInfo))
			.filter(healthInfo -> healthInfo.uid().equals(uid))
			.findFirst()
			.map(healthInfo -> HealthInfoMapper.toModel(healthInfo))
			.orElse(null);
	}
}
