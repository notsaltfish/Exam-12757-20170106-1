package com.chen.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.ssm.mapper.FilmMapper;
import com.chen.ssm.mapper.LanguageMapper;
import com.chen.ssm.po.Film;
import com.chen.ssm.po.Language;
import com.chen.ssm.po.Page;
import com.chen.ssm.po.ResponseData;
import com.chen.ssm.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	private FilmMapper filmMapper;
	
	@Autowired
	private LanguageMapper languageMapper ;
	
	
	public ResponseData<Film> getFilmByPagnation(Page<Film> page){
		List<Film> datas = filmMapper.selectByFilm(page)	;
		List<Object> list = new ArrayList<Object>();
		List<Language> languages = languageMapper.getAllLanguage();
		list.add(datas);
		list.add(languages);
		ResponseData response = new ResponseData();
		response.setDatas(list);
		response.setPage(page);
		response.setTotal(filmMapper.selectCount(page.getEntity()));
		return response;
	}

	@Override
	public void updateByFilm(Film film) {
		filmMapper.updateByPrimaryKey(film);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		
		filmMapper.deleteByPrimaryKeys(ids);
		
	}

	
	
	@Override
	public ResponseData getFilmById(Integer filmId) {
		List<Object> list =  new ArrayList<Object>();
		if(filmId!=null){
			int id = filmId;
			Film film =filmMapper.selectByPrimaryKey((short)id);
			list.add(film);
		}
		List<Language> languages = languageMapper.getAllLanguage();
		list.add(languages);
		ResponseData response = new ResponseData();
		response.setDatas(list);
		return response;
	}

	@Override
	public void insert(Film film) {
		filmMapper.insert(film);
	}
}
