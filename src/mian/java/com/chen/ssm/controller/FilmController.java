package com.chen.ssm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.ssm.po.Film;
import com.chen.ssm.po.Page;
import com.chen.ssm.po.ResponseData;
import com.chen.ssm.service.FilmService;

@Controller
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService filmService ;
	

	

	@RequestMapping("filmList")
	public @ResponseBody ResponseData getFilmList(Page<Film> page,String title,String description){
		if(page.getEntity()==null){
			Film film = new Film();
			film.setTitle(title);
			film.setDescription(description);
			page.setEntity(film);
		}
		ResponseData data = filmService.getFilmByPagnation(page);
		return data;
	}
	
	@ResponseBody
	@RequestMapping("deleteById")
	public ResponseData deleteById(Integer[] filmId){
		filmService.deleteByIds(filmId);
		return null;
	}
	
	@ResponseBody
	@RequestMapping("toupdate")
	public ResponseData toUpdate(Integer filmId){
		ResponseData response = filmService.getFilmById(filmId);
		return response;
	}
	
	
	@ResponseBody
	@RequestMapping("update")
	public ResponseData update(Film film){
		filmService.updateByFilm(film);;
		ResponseData data = new ResponseData();
		data.setTotal(1);
		return data;
	}
	
	@ResponseBody
	@RequestMapping("insert")
	public ResponseData insert(Film film){
		filmService.insert(film);
		ResponseData data = new ResponseData();
		data.setTotal(1);
		return data;
	}
}
