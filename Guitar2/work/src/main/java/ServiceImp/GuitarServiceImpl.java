package ServiceImp;

import java.util.List;

import Dao.GuitarDao;
import Entity.Guitar;
import Service.GuitarService;

public class GuitarServiceImpl implements GuitarService {
	private GuitarDao guitarDao;

	public void setGuitarDao(GuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}

	@Override
	public void addGuitar(Guitar entity) {
		guitarDao.save(entity);
	}

	@Override
	public List<Guitar> queryallGuitar() {
		return guitarDao.findAll(Guitar.class);
	}



}
