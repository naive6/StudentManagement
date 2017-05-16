package dao;

import java.util.List;

import entity.Score;

public interface ScoreDao {
	public boolean add(Score score);
	public boolean delete(int scid);
	public boolean update(Score score);
	public List<Score> queryById(int scid);
}
