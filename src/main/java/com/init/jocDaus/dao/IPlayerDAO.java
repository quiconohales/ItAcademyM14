package com.init.jocDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.jocDaus.dto.Player;



public interface IPlayerDAO extends JpaRepository <Player,Integer>{

}
