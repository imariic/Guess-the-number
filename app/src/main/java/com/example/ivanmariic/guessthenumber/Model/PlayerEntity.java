package com.example.ivanmariic.guessthenumber.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class PlayerEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_name")
    private String playerUsername;

    @NonNull
    @ColumnInfo(name = "password")
    private String playerPassword;

    @ColumnInfo(name = "score")
    private String playerScore;

    @NonNull
    @ColumnInfo(name = "date_of_birth")
    private String dateOfBirth;

    @NonNull
    @ColumnInfo(name = "first_name")
    private String firstName;

    @NonNull
    @ColumnInfo(name = "last_name")
    private String lastName;

    public PlayerEntity() {
    }

    public PlayerEntity(@NonNull String playerUsername, @NonNull String playerPassword, @NonNull String dateOfBirth, @NonNull String firstName, @NonNull String lastName) {
        this.playerUsername = playerUsername;
        this.playerPassword = playerPassword;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getPlayerUsername() {
        return playerUsername;
    }

    public void setPlayerUsername(String playerUsername) {
        this.playerUsername = playerUsername;
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
