package com.chen.ssm.mapper;

import java.util.List;

import com.chen.ssm.po.Film;
import com.chen.ssm.po.Page;

public interface FilmMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(Film record);

    Film selectByPrimaryKey(Short filmId);
    
    List<Film> selectByFilm(Page page);
    
    int updateByPrimaryKey(Film record);
    
    int selectCount(Film film);

	void deleteByPrimaryKeys(Integer[] ids);
}