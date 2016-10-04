package ua.service.implementation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Item;
import ua.form.ItemFilterForm;
import ua.form.ItemForm;
import ua.repository.BrandRepository;
import ua.repository.CategoryRepository;
import ua.repository.CountryRepository;
import ua.repository.ItemRepository;
import ua.repository.PermanRepository;
import ua.repository.SizeRepository;
import ua.service.FileWriter;
import ua.service.ItemService;
import ua.specification.ItemFilterAdapter;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	private BrandRepository brandRepository;
	@Resource
	private ItemRepository itemRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private PermanRepository permanRepository;
	@Autowired
	private SizeRepository sizeRepository;
	/*@Autowired
	private FileWriter fileWriter;*/

	public void save(ItemForm form) {
		Item item = new Item();

		item.setBrand(form.getBrand());
		item.setCategory(form.getCategory());
		item.setCountry(form.getCountry());
		item.setPerman(form.getPerman());
		item.setPrice(Integer.parseInt(form.getPrice()));
		item.setSize(form.getSize());
		item.setName(form.getName());
		item.setId(form.getId());
		item.setPath(form.getPath());
		item.setVersion(form.getVersion());
		itemRepository.saveAndFlush(item);
		/*String extension = fileWriter.write(FileWriter.Folder.ITEM, form.getFile(), item.getId());
		if(extension!=null){
			item.setVersion(form.getVersion()+1);
			item.setPath(extension);
			itemRepository.save(item);
		}*/

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
		form.setBrand(item.getBrand());
		form.setCategory(item.getCategory());
		form.setCountry(item.getCountry());
		form.setId(item.getId());
		form.setKorzina(item.getKorzina());
		form.setPerman(item.getPerman());
		form.setPrice(String.valueOf(item.getPrice()));
		form.setSize(item.getSize());
		form.setName(item.getName());
		form.setPath(item.getPath());
		form.setVersion(item.getVersion());
		return form;
	}

	@Override
	public Item findByName(String name) {

		return itemRepository.findByName(name);
	}

	@Override
	public Page<Item> findAll(Pageable pageable) {
		
		return itemRepository.findAll(pageable);
	}

	@Override
	public Page<Item> findAll(ItemFilterForm form, Pageable pageable) {
		
		return itemRepository.findAll( new ItemFilterAdapter(form), pageable);
	}

}
