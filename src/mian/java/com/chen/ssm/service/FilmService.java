package com.chen.ssm.service;

import com.chen.ssm.po.Film;
import com.chen.ssm.po.Page;
import com.chen.ssm.po.ResponseData;

public interface FilmService {
	 ResponseData<Film> getFilmByPagnation(Page<Film> page);
	 void updateByFilm(Film film);
	 void deleteByIds(Integer[] ids);
	 void insert(Film film);
	ResponseData getFilmById(Integer filmId);
	 
}
