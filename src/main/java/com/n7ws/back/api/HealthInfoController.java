package com.n7ws.back.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.domain.HealthInfoDomain;
import com.n7ws.back.mapper.HealthInfoMapper;
import com.n7ws.back.model.HealthInfoModel;


@RestController
@RequestMapping("/healthInfos")
public class HealthInfoController {
	private Collection<HealthInfoDomain> healthInfos;

	public HealthInfoController() {
		healthInfos = new ArrayList<>();
	}

	@GetMapping
	public Collection<HealthInfoModel> healthInfos() {
		return healthInfos.stream()
			.map(healthInfo -> HealthInfoMapper.toHealthInfoModel(healthInfo))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public HealthInfoModel healthInfo(@PathVariable String uid) {
		return healthInfos.stream()
			.filter(healthInfo -> healthInfo.uid().equals(uid))
			.findFirst()
			.map(healthInfo -> HealthInfoMapper.toHealthInfoModel(healthInfo))
			.orElse(null);
	}
}
