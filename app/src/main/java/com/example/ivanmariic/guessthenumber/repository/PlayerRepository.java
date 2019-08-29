package com.example.ivanmariic.guessthenumber.repository;

import android.content.Context;

import com.example.ivanmariic.guessthenumber.model.PlayerEntity;
import com.example.ivanmariic.guessthenumber.persistence.PlayerDAO;
import com.example.ivanmariic.guessthenumber.persistence.PlayerDatabase;

public class PlayerRepository {

    private static PlayerRepository playerRepository = null;

    private PlayerDAO playerDao;

    private PlayerRepository(){
        playerDao = PlayerDatabase.getInstance().getPlayerDAO();
    }



    public static PlayerRepository getInstance(){
        if(playerRepository == null){

            return playerRepository = new PlayerRepository();
        }
        return playerRepository;
    }

    public String getPlayerUsername(String username){
        return playerDao.getUsername(username);
    }

    public String getPlayerPassword(String password){
        return playerDao.getPassword(password);
    }

    public void deletePlayer(){
        playerDao.deleteTable();
    }

    public void insertPlayer(PlayerEntity player){
        playerDao.insertPlayer(player);
    }


}
