package ServiceImp;

import Dao.GuitarSpecDao;
import Service.GuitarSpecService;

public class GuitarSpecServiceImpl implements GuitarSpecService{
	private GuitarSpecDao guitarSpecDao;

	public void setGuitarSpecDao(GuitarSpecDao guitarSpecDao) {
		this.guitarSpecDao = guitarSpecDao;
	}
	

}
