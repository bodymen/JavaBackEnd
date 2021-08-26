package com.curso.m16.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m16.model.Launchs;
import com.curso.m16.model.Players;
import com.curso.m16.repository.ILaunchsRepository;
import com.curso.m16.repository.IPlayerRepository;
import com.curso.m16.service.Impl.ILaunchsService;

@Service
public class LaunchsService implements ILaunchsService {

	@Autowired
	ILaunchsRepository launchsRepository;
	@Autowired
	IPlayerRepository playerRepository;

	public List<Launchs> getAllLaunchs() {
		List<Launchs> launchs = new ArrayList<Launchs>();
		launchsRepository.findAll().forEach(s -> launchs.add(s));
		return launchs;
	}

	public Launchs getLaunchsById(int id) {
		return launchsRepository.findById(id).get();
	}

	public void saveOrUpdate(Launchs launchs) {
		launchsRepository.save(launchs);
	}

	public void delete(int id) {
		launchsRepository.deleteById(id);
	}

	public void update(Launchs launchs, int pictureid) {
		launchsRepository.save(launchs);
	}

	public void deleteAllByPlayer(List<Launchs> launchs) {
		launchsRepository.deleteAll(launchs);
	}

	public List<Launchs> findAllByPlayers(int id) {
		return launchsRepository.findAllByPlayerId(id);
	}

	public void UpdatePromedio(Players player) {
		List<Launchs> launchs = launchsRepository.findAllByPlayerId(player.getId());
		double truesWin = launchs.stream().filter(s -> s.isWon() == true).count();
		player.setPromedio(truesWin / Double.valueOf(launchs.size()));
		playerRepository.save(player);
	}
}