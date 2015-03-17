package com.scnu.swimmingtrainingsystem.model;

public class TempScore {
	int athlete_id;
	int plan_id;
	int times;
	String up_time;
	String score;

	public int getAthlete_id() {
		return athlete_id;
	}

	public void setAthlete_id(int athlete_id) {
		this.athlete_id = athlete_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getUp_time() {
		return up_time;
	}

	public void setUp_time(String up_time) {
		this.up_time = up_time;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "TempScore [athlete_id=" + athlete_id + ", plan_id=" + plan_id
				+ ", time=" + times + ", up_time=" + up_time + ", score="
				+ score + "]";
	}
}