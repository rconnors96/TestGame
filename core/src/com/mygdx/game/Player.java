package com.mygdx.game;

public class Player {
    private String name;
    private int hitPoints;

    private int healthStat;
    private int weaponHandlingStat;
    private int agilityStat;
    private int shieldsStat;
    private int initiativeStat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHealthStat() {
        return healthStat;
    }

    public void setHealthStat(int healthStat) {
        this.healthStat = healthStat;
    }

    public int getWeaponHandlingStat() {
        return weaponHandlingStat;
    }

    public void setWeaponHandlingStat(int weaponHandlingStat) {
        this.weaponHandlingStat = weaponHandlingStat;
    }

    public int getAgilityStat() {
        return agilityStat;
    }

    public void setAgilityStat(int agilityStat) {
        this.agilityStat = agilityStat;
    }

    public int getShieldsStat() {
        return shieldsStat;
    }

    public void setShieldsStat(int shieldsStat) {
        this.shieldsStat = shieldsStat;
    }

    public int getInitiativeStat() {
        return initiativeStat;
    }

    public void setInitiativeStat(int initiativeStat) {
        this.initiativeStat = initiativeStat;
    }
}
