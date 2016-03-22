package click.tomasz.model;

import java.util.ArrayList;
import java.util.List;

public class CollectionResult<T extends Item> {

	private List<T> items;

	public CollectionResult() {
		this.items = new ArrayList<>();
	}

	public List<T> getItems() {
		return items;
	}
}
