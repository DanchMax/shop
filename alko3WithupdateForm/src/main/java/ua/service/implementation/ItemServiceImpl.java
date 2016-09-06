package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Item;
import ua.form.ItemForm;
import ua.repository.AgingRepository;
import ua.repository.BrandRepository;
import ua.repository.CategoryRepository;
import ua.repository.CountryRepository;
import ua.repository.ItemRepository;
import ua.repository.PermanRepository;
import ua.repository.SizeRepository;
import ua.repository.StarRepository;
import ua.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private AgingRepository agingRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private PermanRepository permanRepository;
	@Autowired
	private SizeRepository sizeRepository;
	@Autowired
	private StarRepository starRepository;

	public void save(ItemForm form) {
		Item item = new Item();
		item.setAging(form.getAging());
		item.setBrand(form.getBrand());
		item.setCategory(form.getCategory());
		item.setCountry(form.getCountry());
		item.setPerman(form.getPerman());
		item.setPrice(form.getPrice());
		item.setSize(form.getSize());
		item.setStar(form.getStar());
		item.setName(form.getName());
		itemRepository.save(item);

	}

	
	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public List<Item> items() {
		return itemRepository.items();
	}

	@Override
	public Item findById(int id) {
		return itemRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		itemRepository.delete(id);
	}

	@Override
	public ItemForm FindForForm(int id) {
		Item item = itemRepository
				.findOneCategoryBrandSizeStarPermanAgingCountry(id);
		ItemForm form = new ItemForm();
		form.setAging(item.getAging());
		form.setBrand(item.getBrand());
		form.setCategory(item.getCategory());
		form.setCountry(item.getCountry());
		form.setId(item.getId());
		form.setKorzina(item.getKorzina());
		form.setPerman(item.getPerman());
		form.setPrice(item.getPrice());
		form.setSize(item.getSize());
		form.setStar(item.getStar());
		form.setName(item.getName());
		return form;
	}

}